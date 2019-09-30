package com.tensquare.spit.article.service;

import com.tensquare.spit.article.entity.Comment;

import java.util.List;


public interface ICommentSerive {
    void add(Comment comment);

    List<Comment> findByArticleId(String articleId);

    Boolean removeById(String id);


}
