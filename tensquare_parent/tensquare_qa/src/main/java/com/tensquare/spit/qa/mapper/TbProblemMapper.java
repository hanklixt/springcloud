package com.tensquare.spit.qa.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tensquare.spit.qa.entity.TbProblem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 问题 Mapper 接口
 * </p>
 *
 * @author lxt
 * @since 2019-09-22
 */
public interface TbProblemMapper extends BaseMapper<TbProblem> {

    @Select("select * from tb_problem a,tb_pl b where a.id=b.problemid AND b.labelid=#{labelId} ORDER\n" +
            "BY replytime DESC")
    List<TbProblem> newList(@Param("labelId") String labelId, Page page);
    @Select("select * from tb_problem a,tb_pl b where a.id=b.problemid AND b.labelid=#{labelId} ORDER\n" +
            "a.reply DESC")
    List<TbProblem>  hotList(@Param("labelId")String labelId,Page page);
    @Select("select * from tb_problem a,tb_pl b where a.id=b.problemid AND b.labelid=#{labelId} AND a.reply=0 ORDER BY replytime DESC ")
    List<TbProblem>  waitList(@Param("labelId")String labelId,Page page);

}
