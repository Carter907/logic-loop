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

    @PostConstruct
    public void init() {
        this.questionService.harvestQuestions();
    }

    @PostMapping("/practice")
    public String updateItem(
            @ModelAttribute("question") Question question,
            Model model
    ) {

        // Process the item here
        // For demonstration, just add a message to the model
        if (question.getUserChoice() != null) {
            boolean userCorrect = question
                    .getUserChoice()
                    .trim()
                    .equals(questionService.getCurrent().getCorrectAnswer());
            model.addAttribute("userCorrect", userCorrect);
            model.addAttribute("userAnswered", true);
        } else {
            model.addAttribute("userAnswered", false);

        }

        questionService.newQuestion();
        model.addAttribute("question", questionService.getCurrent());
        return "index"; // Redirect to success page
    }
}