package com.carter.speers.logicloop.model;

import java.util.List;

public record Question(
        String question,
        List<String> answers,
        String correctAnswer
) {

    
}
