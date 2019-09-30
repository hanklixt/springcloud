package com.tensquare.complaints.mapper;

import com.tensquare.complaints.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentMapper extends MongoRepository<Comment,String> {
}
