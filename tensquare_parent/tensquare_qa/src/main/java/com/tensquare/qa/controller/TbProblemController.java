package com.tensquare.qa.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.tensquare.qa.entity.TbProblem;
import com.tensquare.qa.service.ITbProblemService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 问题 前端控制器
 * </p>
 *
 * @author lxt
 * @since 2019-09-22
 */
@RestController
@RequestMapping("/problem")
public class TbProblemController extends BaseController {

    @Autowired
    private ITbProblemService problemService;

    @GetMapping("newList/{labelId}/{pageNo}/{pageSize}")
    public Mono<Result> newList(@PathVariable("labelId") String  labelId,@PathVariable("pageNo") Long pageNo,@PathVariable("pageSize") Long pageSize) {
        Page<TbProblem> tbProblemPage = problemService.newList(labelId, pageNo, pageSize);
        return success(tbProblemPage);
    }
    @GetMapping("hotList/{labelId}/{pageNo}/{pageSize}")
    public Mono<Result> hotList(@PathVariable("labelId") String  labelId,@PathVariable("pageNo") Long pageNo,@PathVariable("pageSize") Long pageSize) {
        Page<TbProblem> tbProblemPage = problemService.hotList(labelId, pageNo, pageSize);
        return success(tbProblemPage);
    }
    @GetMapping("waitList/{labelId}/{pageNo}/{pageSize}")
    public Mono<Result> waitList(@PathVariable("labelId") String  labelId,@PathVariable("pageNo") Long pageNo,@PathVariable("pageSize") Long pageSize) {
        Page<TbProblem> tbProblemPage = problemService.waitList(labelId, pageNo, pageSize);
        return success(tbProblemPage);
    }



    @GetMapping
    public Mono<Result> getAll() {
        List<TbProblem> list = problemService.list();
        return success(list);
    }

    @PostMapping
    public Mono<Result> add(@RequestBody TbProblem problem) {
        boolean save = problemService.save(problem);
        return success(save);
    }
    @GetMapping("/{problemId}")
    public Mono<Result> findById(@PathVariable("problemId") String  problemId) {
        TbProblem byId = problemService.getById(problemId);
        return success(byId);
    }

    @DeleteMapping("/{problemId}")
    public Mono<Result> removeById(@PathVariable("problemId") String  problemId) {
        boolean b = problemService.removeById(problemId);
        return success(b);
    }

    @PutMapping("/{problemId}")
    public Mono<Result> updateById(@PathVariable("problemId") String  problemId,@RequestBody TbProblem problem) {
        problem.setId(problemId);
        boolean b = problemService.updateById(problem);
        return success(b);
    }
    @PostMapping("/search/{page}/{size}")
    public Mono<Result> searchPage(@PathVariable("page") Long page,@PathVariable("size")Long size,@RequestBody TbProblem problem){
        LambdaQueryWrapper<TbProblem> tbProblemLambdaQueryWrapper = getTbProblemLambdaQueryWrapper(problem);
        IPage<TbProblem> pageResult = problemService.page(new Page<TbProblem>().setCurrent(page).setSize(size), tbProblemLambdaQueryWrapper);
        return success(pageResult);

    }


    @PostMapping("/search")
    public Mono<Result> search(@RequestBody TbProblem problem){
        LambdaQueryWrapper<TbProblem> tbProblemLambdaQueryWrapper = getTbProblemLambdaQueryWrapper(problem);
        List<TbProblem> list = problemService.list(tbProblemLambdaQueryWrapper);
        return success(list);
    }

    private LambdaQueryWrapper<TbProblem> getTbProblemLambdaQueryWrapper(@RequestBody TbProblem problem) {
        LambdaQueryWrapper<TbProblem> tbProblemLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (Objects.nonNull(problem.getNickname())){
            tbProblemLambdaQueryWrapper.like(TbProblem::getNickname,problem.getNickname());
        }
        if (Objects.nonNull(problem.getTitle())){
            tbProblemLambdaQueryWrapper.like(TbProblem::getTitle,problem.getTitle());
        }
        return tbProblemLambdaQueryWrapper;
    }


}
