package com.tensquare.spit.article.controller;

import com.tensquare.spit.article.entity.Comment;
import com.tensquare.spit.article.service.ICommentSerive;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController extends BaseController {

    @Autowired
    private ICommentSerive commentSerive;

    public  Mono<Result> save(@RequestBody Comment comment){
        commentSerive.add(comment);
        return success();
    }

    @GetMapping(value="/article/{articleid}")
    public Mono<Result> findByArticleid(@PathVariable String articleid){
        List<Comment> byArticleId = commentSerive.findByArticleId(articleid);
        return success(byArticleId);
    }
    @DeleteMapping("/article/{id}")
    public Mono<Result> RemoveById(@PathVariable String id){
        commentSerive.removeById(id);
        return success();
    }



}
