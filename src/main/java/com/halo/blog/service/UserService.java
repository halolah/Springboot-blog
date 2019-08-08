package com.halo.blog.service;

import com.halo.blog.mapper.UserMapper;
import com.halo.blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by halo on 2019/8/8.
 */

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public void createOrUpdate(User user) {
        User dbUser = userMapper.findByAccountId(user.getAccount_id());
        if(dbUser == null){
            //插入
            user.setGmt_create(System.currentTimeMillis());
            user.setGmt_modified(user.getGmt_create());
            userMapper.insert(user);

        }else{
            //更新
            dbUser.setToken(user.getToken());
            dbUser.setName(user.getName());
            dbUser.setGmt_create(System.currentTimeMillis());
            dbUser.setGmt_modified(user.getGmt_create());
            dbUser.setAvatar_url(user.getAvatar_url());
            userMapper.update(dbUser);
        }

    }
}
