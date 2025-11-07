package com.pranay.question_service.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class QuestionWrapper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    public QuestionWrapper(Integer id, String option1, String questionTitle, String option3, String option2, String option4) {
        this.id = id;
        this.option1 = option1;
        this.questionTitle = questionTitle;
        this.option3 = option3;
        this.option2 = option2;
        this.option4 = option4;
    }
}
