package com.tensquare.spit.article.service.impl;

import com.tensquare.spit.article.entity.Comment;
import com.tensquare.spit.article.repository.CommentMongoRepository;
import com.tensquare.spit.article.service.ICommentSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

@Service
public class ICommentSeriveImpl implements ICommentSerive {
    @Autowired
    private CommentMongoRepository commentMongoRepository;
    @Autowired
    private IdWorker idWorker;
    @Override
    public void add(Comment comment) {
        comment.set_id(idWorker.nextId()+"");
        commentMongoRepository.save(comment);
    }

    @Override
    public List<Comment> findByArticleId(String articleId) {
        List<Comment> byArticleid = commentMongoRepository.findByArticleid(articleId);
        return byArticleid;
    }

    @Override
    public Boolean removeById(String id) {
          commentMongoRepository.deleteById(id);
        return Boolean.TRUE;
    }


}
