package com.tensquare.article.controller;


import com.fasterxml.jackson.databind.ser.Serializers;
import com.tensquare.article.constract.CacheKey;
import com.tensquare.article.entity.TbArticle;
import com.tensquare.article.service.ITbArticleService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 文章 前端控制器
 * </p>
 *
 * @author lxt
 * @since 2019-09-22
 */
@RestController
@RequestMapping("/article")
public class TbArticleController extends BaseController {

    @Autowired
    private ITbArticleService tbArticleService;

    @Autowired
    private RedisTemplate redisTemplate;

    @PutMapping("/examine/{articleId}")
    public Mono<Result> updateStatus(@PathVariable("articleId") String id){
        TbArticle article=new TbArticle();
        boolean b = tbArticleService.updateById(article.setState("1").setId(id));
        return success(b);
    }

    @PutMapping("/thumbup/{articleId}")
    public Mono<Result> thumbup(@PathVariable("articleId") String id){
        tbArticleService.addThumbup(id);
        return success();
    }

    @GetMapping("/{articleId}")
    public  Mono<Result> findById(@PathVariable("articleId") String articleId){
        Object o = redisTemplate.opsForValue().get(String.format(CacheKey.articleKey, articleId));
        TbArticle article;
        if (ObjectUtils.isEmpty(o)){
             article = tbArticleService.getById(articleId);
             redisTemplate.opsForValue().set(String.format(CacheKey.articleKey,articleId),article,1, TimeUnit.DAYS);
             return success(article);
        }
        article= (TbArticle) o;
        return success(article);
    }

    @PutMapping("/{articleId}")
    public  Mono<Result> updateById(@PathVariable("articleId") String articleId,@RequestBody TbArticle tbArticle){
        tbArticle.setId(articleId);
        boolean b = tbArticleService.updateById(tbArticle);
        if (b){
            redisTemplate.delete(String.format(CacheKey.articleKey,articleId));
        }
        return success(b);
    }
    @DeleteMapping("/{articleId}")
    public  Mono<Result> deleteById(@PathVariable("articleId") String articleId){
        boolean b = tbArticleService.removeById(articleId);
        redisTemplate.delete(String.format(CacheKey.articleKey,articleId));
        return success(b);
    }






}
