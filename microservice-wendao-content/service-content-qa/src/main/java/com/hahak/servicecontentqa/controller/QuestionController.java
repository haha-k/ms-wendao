package com.hahak.servicecontentqa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hahak.servicecontentqa.dto.Answer;
import com.hahak.servicecontentqa.dto.Question;
import com.hahak.servicecontentqa.service.AnswerService;
import com.hahak.servicecontentqa.service.QuestionService;

import entity.BaseResponse;
import enums.BaseStatusCode;

/**
 * @ClassName questionController
 * @Description
 * @Author haha
 * @Date 2020/5/20 下午 17:47
 * @Version 1.0
 **/

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private AnswerService answerService;

    @Autowired
    private QuestionService questionService;

    @GetMapping("")
    public BaseResponse getQuestions(){
        List<Question> questions = questionService.list();
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),questions);
    }

    @GetMapping("/{questionId}")
    public BaseResponse getQuestionDetail(@PathVariable Integer questionId){
        Question question = questionService.getById(questionId);
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),question);
    }

    @DeleteMapping("/{questionId}")
    public BaseResponse deleteQuestionDetail(@PathVariable Integer questionId){
//        Answer question = questionService.getById(questionId);
        Boolean isSuccess = questionService.removeById(questionId);
        if(!isSuccess){
            return new BaseResponse(BaseStatusCode.ERROR.getCode(),BaseStatusCode.ERROR.getMsg(),isSuccess);
        }
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),isSuccess);
    }

    @PostMapping("")
    public BaseResponse postQuestion(@RequestBody Question question){
//        Question question = questionService.getById(questionId);
        questionService.save(question);
//        if(isSuccess == false){
//            return new BaseResponse(BaseStatusCode.ERROR.getCode(),BaseStatusCode.ERROR.getMsg(),isSuccess);
//        }
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),true);
    }


    @GetMapping("/{questionId}/answers")
    public BaseResponse getAnswerDetail(@PathVariable Integer questionId){
        QueryWrapper<Answer> answerQueryWrapper = new QueryWrapper<>();
        answerQueryWrapper.eq("question_id",questionId);
        List<Answer> answers = answerService.list(answerQueryWrapper);
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),answers);
    }

//    @GetMapping("/{questionId}/answer/{answerId}")
//    public BaseResponse getQuestionDetail(@PathVariable Integer questionId,@PathVariable Integer answerId){
//        QueryWrapper<Answer> answerQueryWrapper = new QueryWrapper<>();
//        answerQueryWrapper.eq("question_id",questionId);
//        answerQueryWrapper.eq("answer_id",answerId);
//        Answer answer = answerService.getOne(answerQueryWrapper);
//        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),answer);
//    }

}
