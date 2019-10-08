package com.tensquare.search.controller;

import com.tensquare.search.entity.Article;
import com.tensquare.search.service.ArticleService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/article")
public class ArticleController extends BaseController {
    @Autowired
    private ArticleService articleService;

    @PostMapping
    public Mono<Result> save(@RequestBody Article article){
     articleService.save(article);
     return success();
    }
    

}
