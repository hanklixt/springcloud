package com.tensuare.esearch.service;

import com.tensuare.esearch.entity.Article;
import com.tensuare.esearch.respistory.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import util.IdWorker;
@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private IdWorker idWorker;

    public  void  save(Article article){
        articleRepository.save(article);
    }

    public Page<Article> findByTitleLike(String keywords,int page,int size){
      Pageable pageable= PageRequest.of(page-1,size);
        Page<Article> byTitleOrContentLike = articleRepository.findByTitleOrContentLike(keywords, keywords, pageable);
        return byTitleOrContentLike;
    }

}
