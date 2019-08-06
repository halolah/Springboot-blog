package com.halo.blog.dto;

import com.halo.blog.model.User;
import lombok.Data;

/**
 * Created by halo on 2019/8/5.
 */

@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmt_create;


    private Long modified;
    private Integer creator;
    private Integer comment_count;
    private Integer like_count;
    private Integer view_count;
    private User user;
}

