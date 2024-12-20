package com.carter.speers.proplogicmastery.controller;

import com.carter.speers.proplogicmastery.model.Question;
import com.carter.speers.proplogicmastery.model.UserChoice;
import com.carter.speers.proplogicmastery.service.QuestionService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

@Controller
public class QuestionController {

    private QuestionService questionService;

    @Autowired
    public QuestionController(@Qualifier("questionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/practice")
    public Question updateItem() {

        return new Question("test question", java.util.List.of("a","b","c"), "a");
    }
}