package com.carter.speers.logicloop.controller;

import com.carter.speers.logicloop.model.Question;
import com.carter.speers.logicloop.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestionController {

    private QuestionService questionService;

    @Autowired
    public QuestionController(@Qualifier("questionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/question")
    public Question getQuestion() {
        return questionService.promptQuestion();
    }
}