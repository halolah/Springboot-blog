package com.halo.blog.mapper;

import com.halo.blog.model.Question;
import com.halo.blog.model.QuestionExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface QuestionExMapper {
    int incView(Question record);


}