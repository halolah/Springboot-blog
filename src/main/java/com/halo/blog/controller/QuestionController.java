package com.halo.blog.controller;

import com.halo.blog.dto.CommentDTO;
import com.halo.blog.dto.QuestionDTO;
import com.halo.blog.service.CommentService;
import com.halo.blog.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by halo on 2019/8/6.
 */
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Long id,
                           Model model) {

        List<CommentDTO> comments = commentService.listByQuestionId(id);

        // 累加阅读数
        questionService.incView(id);
        QuestionDTO questionDTO = questionService.getById(id);
        model.addAttribute("question", questionDTO);
        model.addAttribute("comments", comments);

        return "question";
    }
}
