package com.halo.blog.mapper;

import com.halo.blog.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
public  interface UserMapper {
    @Insert("insert into myh2 (NAME , ACCOUNT_ID, TOKEN, GMT_CREATE, GMT_MODIFIED, avatar_url) values (#{name}, #{account_id}, #{token}, #{gmt_create}, #{gmt_modified}, #{avatar_url})")
    void insert(User user);

    /**
     *
     * @param token
     * @return
     * 当参数不是class，需要用param参数
     */

    @Select("select * from MYH2 where token=#{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from MYH2 where id = #{id}")
    User findById(@Param("id") Integer id);
}
