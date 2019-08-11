package com.halo.blog.service;

import com.halo.blog.dto.PaginationDTO;
import com.halo.blog.dto.QuestionDTO;
import com.halo.blog.exception.CustomizeErrorCode;
import com.halo.blog.exception.CustomizeException;
import com.halo.blog.mapper.QuestionExMapper;
import com.halo.blog.mapper.QuestionMapper;
import com.halo.blog.mapper.UserMapper;
import com.halo.blog.model.Question;
import com.halo.blog.model.QuestionExample;
import com.halo.blog.model.User;
import com.halo.blog.util.MyUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by halo on 2019/8/5.
 * service用于组装多个mapper，即userMapper和questionMapper
 */

@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionExMapper questionExMapper;

    @Autowired
    private UserMapper userMapper;

    /*
    size * (page - 1)
     */

    public PaginationDTO list(Integer page, Integer size) {
        Integer offset = size * (page - 1);
        List<Question> questions = questionMapper.selectByExampleWithRowbounds(new QuestionExample(), new RowBounds(offset, size));
        List<QuestionDTO> questionDTOList = new ArrayList<>();

        PaginationDTO paginationDTO = new PaginationDTO();

        Integer totalCount = (int) questionMapper.countByExample(new QuestionExample());
        paginationDTO.setPagination(totalCount, page, size);
        if (page < 1) {
            page = 1;
        }
        if (page > paginationDTO.getTotalPage()) {
            page = paginationDTO.getTotalPage();
        }


        for (Question question : questions) {
            User user = userMapper.selectByPrimaryKey(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            MyUtils.myCopyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }

        paginationDTO.setQuestions(questionDTOList);

        return paginationDTO;
    }

    public PaginationDTO list(Long userId, Integer page, Integer size) {

        Integer offset = size * (page - 1);


        QuestionExample example = new QuestionExample();
        example.createCriteria().andCreatorEqualTo(userId);
        List<Question> questions = questionMapper.selectByExampleWithRowbounds(example, new RowBounds(offset, size));
        List<QuestionDTO> questionDTOList = new ArrayList<>();

        PaginationDTO paginationDTO = new PaginationDTO();

        QuestionExample questionExample = new QuestionExample();
        questionExample.createCriteria().andCreatorEqualTo(userId);
        Integer totalCount = (int) questionMapper.countByExample(questionExample);
        paginationDTO.setPagination(totalCount, page, size);
        if (page < 1) {
            page = 1;
        }
        if (page > paginationDTO.getTotalPage()) {
            page = paginationDTO.getTotalPage();
        }

        for (Question question : questions) {
            User user = userMapper.selectByPrimaryKey(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            MyUtils.myCopyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }

        paginationDTO.setQuestions(questionDTOList);
        return paginationDTO;
    }

    public QuestionDTO getById(Long id) {
        Question question = questionMapper.selectByPrimaryKey(id);
        if (question == null) {
            throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
        }

        User user = userMapper.selectByPrimaryKey(question.getCreator());
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setUser(user);
        MyUtils.myCopyProperties(question, questionDTO);
        return questionDTO;
    }

    public void createOrUpdate(Question question) {
        if (question.getId() == null) {
            //创建
            question.setCommentCount(0);
            question.setViewCount(0);
            question.setLikeCount(0);
            questionMapper.insert(question);
        } else {
            //更新
            Question updateQuestion = new Question();
            updateQuestion.setModified(System.currentTimeMillis());
            updateQuestion.setTitle(question.getTitle());
            updateQuestion.setDescription(question.getDescription());
            updateQuestion.setTag(question.getTag());
            QuestionExample questionExample = new QuestionExample();
            questionExample.createCriteria().andIdEqualTo(question.getId());
            int updated = questionMapper.updateByExampleSelective(updateQuestion, questionExample);
            if (updated != 1) {
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);

            }
        }

    }

    public void incView(Long id) {
        Question question = new Question();
        question.setId(id);
        question.setViewCount(1);
        questionExMapper.incView(question);
    }
}
