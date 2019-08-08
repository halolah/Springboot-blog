package com.halo.blog.mapper;

import com.halo.blog.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by halo on 2019/8/3.
 */

@Mapper
public interface QuestionMapper {

    @Insert("insert into question(title, description, tag, gmt_create, modified, creator)" +
            " values(#{title},#{description}, #{tag}, #{gmt_create}, #{modified}, #{creator})")
    void create(Question question);


    @Select("select * from question limit #{offset}, #{size}")
    List<Question> list(@Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    @Select("select count(1) from question")
    Integer count();

    @Select("select * from question where creator=${userId} limit #{offset}, #{size}")
    List<Question> listByUserId(@Param(value = "userId") Integer userId,
                                @Param(value = "offset") Integer offset,
                                @Param(value = "size") Integer size);

    @Select("select count(1) from question where creator=#{userId}")
    Integer countByUserID(@Param(value = "userId") Integer userId);

    @Select("select * from question where id=#{id}")
    Question getById(@Param(value = "id") Integer id);
}

