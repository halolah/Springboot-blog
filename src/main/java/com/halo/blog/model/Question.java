package com.halo.blog.model;

import lombok.Data;
import sun.util.calendar.LocalGregorianCalendar;

/**
 * Created by halo on 2019/8/3.
 */
@Data
public class Question {
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
}


