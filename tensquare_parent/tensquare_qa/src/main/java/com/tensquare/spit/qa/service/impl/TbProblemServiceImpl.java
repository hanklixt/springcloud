package com.tensquare.spit.qa.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tensquare.spit.qa.entity.TbProblem;
import com.tensquare.spit.qa.mapper.TbProblemMapper;
import com.tensquare.spit.qa.service.ITbProblemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 问题 服务实现类
 * </p>
 *
 * @author lxt
 * @since 2019-09-22
 */
@Service
public class TbProblemServiceImpl extends ServiceImpl<TbProblemMapper, TbProblem> implements ITbProblemService {

    @Autowired
    private TbProblemMapper tbProblemMapper;

    @Override
    public Page<TbProblem> newList(String labelId, Long pageNo, Long pageSize) {
        Page<TbProblem> tbProblemPage = new Page<>(pageNo, pageSize);
        return tbProblemPage.setRecords(tbProblemMapper.newList(labelId,tbProblemPage));
    }

    @Override
    public Page<TbProblem> hotList(String labelId, Long pageNo, Long pageSize) {
        Page<TbProblem> tbProblemPage = new Page<>(pageNo, pageSize);
        return tbProblemPage.setRecords(tbProblemMapper.hotList(labelId,tbProblemPage));
    }

    @Override
    public Page<TbProblem> waitList(String labelId, Long pageNo, Long pageSize) {
        Page<TbProblem> tbProblemPage = new Page<>(pageNo, pageSize);
        return tbProblemPage.setRecords(tbProblemMapper.hotList(labelId,tbProblemPage));
    }
}
