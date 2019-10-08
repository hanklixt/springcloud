package com.tensquare.search.service;

import com.tensquare.search.entity.Article;
import com.tensquare.search.respistory.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

}
