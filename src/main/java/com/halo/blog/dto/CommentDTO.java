package com.halo.blog.dto;

import lombok.Data;

/**
 * Created by halo on 2019/8/9.
 */
@Data
public class CommentDTO {
    private Long parentId;
    private String content;
    private Integer type;
}
