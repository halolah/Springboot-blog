package com.halo.blog.mapper;

import com.halo.blog.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by halo on 2019/8/3.
 */

@Mapper
public interface QuestionMapper {

    @Insert("insert into question(title, description, tag, gmt_create, modified, creator)" +
            " values(#{title},#{description}, #{tag}, #{gmt_create}, #{modified}, #{creator})")
    void create(Question question);


}
