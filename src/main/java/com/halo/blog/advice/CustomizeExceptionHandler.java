package com.halo.blog.advice;

import com.alibaba.fastjson.JSON;
import com.halo.blog.dto.ResultDTO;
import com.halo.blog.exception.CustomizeErrorCode;
import com.halo.blog.exception.CustomizeException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by halo on 2019/8/8.
 */

@ControllerAdvice
public class CustomizeExceptionHandler {
    @ExceptionHandler(Exception.class)
    ModelAndView handle(HttpServletRequest request, Throwable ex, Model model, HttpServletResponse response) {
        String contentType = request.getContentType();
        if ("application/json".equals(contentType)) {
            // 返回json
            ResultDTO resultDTO;
            if (ex instanceof CustomizeException) {
                resultDTO = ResultDTO.errorOf((CustomizeException) ex);
            } else {
                resultDTO = ResultDTO.errorOf(CustomizeErrorCode.SYSTEM_ERROR);
            }
            try {
                response.setContentType("application/json");
                response.setStatus(200);
                response.setCharacterEncoding("utf-8");
                PrintWriter writer = response.getWriter();
                writer.write(JSON.toJSONString(resultDTO));
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;

        } else {
            // 页面跳转
        if (ex instanceof CustomizeException) {
            model.addAttribute("message", ex.getMessage());

        } else {
            model.addAttribute("message", CustomizeErrorCode.SYSTEM_ERROR);
        }
        return new ModelAndView("error");
        }
    }

}
