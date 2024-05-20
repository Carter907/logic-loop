package com.carter.speers.proplogicmastery.configuration;

import com.carter.speers.proplogicmastery.service.QuestionService;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
public class QuestionConfiguration {
    @Bean(name = "questionService")
    public QuestionService questionService(OllamaChatClient client) {
        var service = new QuestionService(client);
        return service;
    }
}
