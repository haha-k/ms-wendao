package com.hahak.serviceContentArticle.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hahak.serviceContentArticle.dto.Article;
import com.hahak.serviceContentArticle.mapper.ArticleMapper;
import com.hahak.serviceContentArticle.service.ArticleService;


/**
 * @ClassName answerSerivceImpl
 * @Description
 * @Author haha
 * @Date 2020/5/20 下午 22:21
 * @Version 1.0
 **/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
}
