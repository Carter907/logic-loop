package com.carter.speers.proplogicmastery.service;

import com.carter.speers.proplogicmastery.model.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.ai.parser.BeanOutputParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

@Service
public class QuestionService {

    private final Logger logger = LoggerFactory.getLogger(QuestionService.class);
    private Question current;
    private OllamaChatClient client;
    private BlockingDeque<Question> questions = new LinkedBlockingDeque<>(5);


    @Autowired
    public QuestionService(OllamaChatClient client) {
        this.client = client;

    }
    public Question promptQuestion() {
        logger.info("crafting question...");
        String promptText = """
        Generate a Propositional Logic question with 4 answer choices and a correct answer
        {format}
        """;
        var outputParser = new BeanOutputParser<>(Question.class);
        PromptTemplate promptTemplate = new PromptTemplate(promptText, Map.of("format", outputParser.getFormat()));
        Prompt prompt = promptTemplate.create();
        Generation generation = client.call(prompt).getResult();
        return outputParser.parse(generation.getOutput().getContent());
    }
    public void newQuestion() {
        try {
            if (questions.peek() != null) {
                current = questions.takeFirst();
            }
        } catch (InterruptedException _) {
            logger.error("interrupted exception");
        }
    }

    @Async("taskExecutor")
    public void harvestQuestions() {
        while (true) {
            try {
                questions.put(promptQuestion());

                logger.info("harvested question {}", questions.size());
                logger.info("questions size: {}", questions.size());
            } catch (InterruptedException _) {
                logger.error("failed to harvest question");
            }
        }
    }


    public Question getCurrent() {
        return current;
    }

    public void setCurrent(Question current) {
        this.current = current;
    }

    public int getTotal() {
        return questions.size();
    }
}
