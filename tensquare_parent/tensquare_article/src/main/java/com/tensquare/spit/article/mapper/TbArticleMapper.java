package com.tensquare.spit.article.mapper;

import com.tensquare.spit.article.entity.TbArticle;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * 文章 Mapper 接口
 * </p>
 *
 * @author lxt
 * @since 2019-09-22
 */
public interface TbArticleMapper extends BaseMapper<TbArticle> {

    @Update("update tb_article set thumbup=thumbup+1 where id =#{id}")
    public void addThumbup(@Param("id") String id);
}
