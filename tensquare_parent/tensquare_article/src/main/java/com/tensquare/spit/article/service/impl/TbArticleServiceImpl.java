package com.tensquare.spit.article.service.impl;

import com.tensquare.spit.article.entity.TbArticle;
import com.tensquare.spit.article.mapper.TbArticleMapper;
import com.tensquare.spit.article.service.ITbArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章 服务实现类
 * </p>
 *
 * @author lxt
 * @since 2019-09-22
 */
@Service
public class TbArticleServiceImpl extends ServiceImpl<TbArticleMapper, TbArticle> implements ITbArticleService {

    @Autowired
    private TbArticleMapper articleMapper;

    @Override
    public void addThumbup(String id) {
     articleMapper.addThumbup(id);
    }
}
