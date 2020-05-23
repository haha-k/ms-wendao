package com.hahak.serviceContentArticle.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.hahak.serviceContentArticle.dto.Article;
import com.hahak.serviceContentArticle.service.ArticleService;

import entity.BaseResponse;
import enums.BaseStatusCode;

/**
 * @ClassName articleController
 * @Description
 * @Author haha
 * @Date 2020/5/20 下午 17:47
 * @Version 1.0
 **/
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("")
    public BaseResponse getArticles(){
        List<Article> articles = articleService.list();
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),articles);
    }

    @GetMapping("/{articleId}")
    public BaseResponse getArticleDetail(@PathVariable Integer articleId){
        Article article = articleService.getById(articleId);
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),article);
    }

    @DeleteMapping("/{articleId}")
    public BaseResponse deleteArticleDetail(@PathVariable Integer articleId){
//        Article article = articleService.getById(articleId);
        Boolean isSuccess = articleService.removeById(articleId);
        if(!isSuccess){
            return new BaseResponse(BaseStatusCode.ERROR.getCode(),BaseStatusCode.ERROR.getMsg(),isSuccess);
        }
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),isSuccess);
    }

    @PostMapping("")
    public BaseResponse postArticle(@RequestBody Article article){
//        Article article = articleService.getById(articleId);
        articleService.save(article);
//        if(isSuccess == false){
//            return new BaseResponse(BaseStatusCode.ERROR.getCode(),BaseStatusCode.ERROR.getMsg(),isSuccess);
//        }
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),true);
    }




}
