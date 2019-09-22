package com.tensquare.article.service;

import com.tensquare.article.entity.TbArticle;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 文章 服务类
 * </p>
 *
 * @author lxt
 * @since 2019-09-22
 */
public interface ITbArticleService extends IService<TbArticle> {

    void addThumbup(String id);
}
