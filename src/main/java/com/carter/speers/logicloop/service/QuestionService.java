package com.carter.speers.logicloop.service;

import com.carter.speers.logicloop.model.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.ai.parser.BeanOutputParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class QuestionService {
    private final Logger logger = LoggerFactory.getLogger(QuestionService.class);
    private OllamaChatClient client;

    @Autowired
    public QuestionService(OllamaChatClient client) {
        this.client = client;

    }
    public Question promptQuestion() {
        logger.info("crafting question...");
        String promptText = """
        Generate a Propositional Logic question with 4 answer choices and a correct answer.
        Do not include any explanations, only provide a RFC8259 compliant JSON response following this format without deviation.\s
        Remove the ```json markdown surrounding the output including the trailing "```"
        {format}
        """;
        var outputParser = new BeanOutputParser<>(Question.class);
        PromptTemplate promptTemplate = new PromptTemplate(promptText, Map.of("format", outputParser.getFormat()));
        Prompt prompt = promptTemplate.create();
        Generation generation = client.call(prompt).getResult();
        return outputParser.parse(generation.getOutput().getContent());
    }

}
