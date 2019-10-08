package com.tensuare.esearch.controller;

import com.tensuare.esearch.entity.Article;
import com.tensuare.esearch.service.ArticleService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleController extends BaseController {
    @Autowired
    private ArticleService articleService;

    @PostMapping
    public Mono<Result> save(@RequestBody Article article){
     articleService.save(article);
     return success();
    }
    @GetMapping
    public Mono<Result> findAll(){
        return success();
    }

    @GetMapping("/{articleId}")
    public Mono<Result> findByArticleId(@PathVariable String articleId){
        return success();
    }

    @PostMapping("/search/{page}/{size}")
    public Mono<Result> page(@PathVariable Integer page,@PathVariable Integer size,@RequestBody Article article){
        Page<Article> byTitleLike = articleService.findByTitleLike(article.getTitle(), page, size);
        return success(byTitleLike);
    }




}
