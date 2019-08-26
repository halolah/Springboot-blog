package com.halo.blog.mapper;

import com.halo.blog.model.Question;

import java.util.List;

public interface QuestionExMapper {
    int incView(Question record);

    int incComment(Question record);

    List<Question> selectRelated(Question question);

}