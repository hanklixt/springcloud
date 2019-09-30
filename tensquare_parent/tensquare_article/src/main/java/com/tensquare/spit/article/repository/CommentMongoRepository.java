package com.tensquare.spit.article.repository;

import com.tensquare.spit.article.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentMongoRepository extends MongoRepository<Comment,String> {

    /**
     * 根据文章id查询评论列表
     * @param articleId
     * @return
     */
    List<Comment> findByArticleid(String articleId);


}
