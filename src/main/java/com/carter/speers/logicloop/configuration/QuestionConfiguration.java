package com.carter.speers.logicloop.configuration;

import com.carter.speers.logicloop.service.QuestionService;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuestionConfiguration {
    @Bean(name = "questionService")
    public QuestionService questionService(OllamaChatClient client) {
        var service = new QuestionService(client);
        return service;
    }
}
