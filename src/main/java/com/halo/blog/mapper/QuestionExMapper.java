package com.halo.blog.mapper;

import com.halo.blog.model.Question;

public interface QuestionExMapper {
    int incView(Question record);

    int incComment(Question record);


}