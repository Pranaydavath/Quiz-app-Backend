package com.pranay.question_service.Dao;


import com.pranay.question_service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface  QuestionDao extends JpaRepository<Question, Integer> {

List<Question> findByCategory(String category);

    // ... (at the end of the file, inside the interface)
    @Query("SELECT DISTINCT q.category FROM Question q")
    List<String> findDistinctCategories();

    @Query(value = "SELECT q.id FROM question q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
List<Integer> findRandomQuestionsByCategory(String category, Integer numQ);

}
