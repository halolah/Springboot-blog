package com.halo.blog.service;

import com.halo.blog.enums.CommentTypesEnum;
import com.halo.blog.exception.CustomizeErrorCode;
import com.halo.blog.exception.CustomizeException;
import com.halo.blog.mapper.CommentMapper;
import com.halo.blog.mapper.QuestionExMapper;
import com.halo.blog.mapper.QuestionMapper;
import com.halo.blog.model.Comment;
import com.halo.blog.model.Question;
import com.halo.blog.model.QuestionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;

/**
 * Created by halo on 2019/8/9.
 */

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionExMapper questionExMapper;

    @Transient
    public void insert(Comment comment) throws CustomizeException {
        // 判断评论的对象是否存在，若不存在，抛出异常
        if (comment.getParentId() == null || comment.getParentId() == 0) {
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }
        // 判断评论的类型是否在自定义的类型(问题或评论)
        if (comment.getType() == null || !CommentTypesEnum.isExist(comment.getType())) {
            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_NOT_EXIST);
        }

        if (comment.getType().equals(CommentTypesEnum.COMMENT.getType())) {
            // 回复评论
            Comment dbComment = commentMapper.selectByPrimaryKey(comment.getParentId());
            if (dbComment == null) {
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_EXIST);
            }

            commentMapper.insert(dbComment);

        } else {
            // 回复问题
            Question question = questionMapper.selectByPrimaryKey(comment.getParentId());
            if (question == null) {
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            commentMapper.insert(comment);
            question.setCommentCount(1);
            questionExMapper.incComment(question);
        }
    }

}
