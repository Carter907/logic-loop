package com.carter.speers.proplogicmastery.controller;

import com.carter.speers.proplogicmastery.model.Question;
import com.carter.speers.proplogicmastery.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("question", null);
        return "index";
    }
}
