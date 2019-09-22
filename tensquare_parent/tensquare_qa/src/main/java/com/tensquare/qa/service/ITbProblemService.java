package com.tensquare.qa.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tensquare.qa.entity.TbProblem;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 问题 服务类
 * </p>
 *
 * @author lxt
 * @since 2019-09-22
 */
public interface ITbProblemService extends IService<TbProblem> {

    Page<TbProblem> newList(String labelId, Long pageNo, Long pageSize);

    Page<TbProblem>  hotList(String labelId,Long pageNo,Long pageSize);

    Page<TbProblem>  waitList(String labelId,Long pageNo,Long pageSize);

}
