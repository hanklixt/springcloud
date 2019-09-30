package com.tensquare.spit.recruit.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tensquare.spit.recruit.entity.TbRecruit;
import com.tensquare.spit.recruit.service.ITbRecruitService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 职位 前端控制器
 * </p>
 *
 * @author lxt
 * @since 2019-09-22
 */
@RestController
@RequestMapping("/recruit")
public class TbRecruitController extends  BaseController{
    @Autowired
   private ITbRecruitService tbRecruitService;

   @PostMapping
   public Mono<Result> add(@RequestBody TbRecruit recruit){
        boolean save = tbRecruitService.save(recruit);
        return success(save);
    }

    @GetMapping
    public Mono<Result> getAll(){
        List<TbRecruit> list = tbRecruitService.list();
        return success(list);
   }

   @GetMapping("/{recruitId}")
    public Mono<Result> findById(@PathVariable("recruitId") String id){
       TbRecruit byId = tbRecruitService.getById(id);
       return success(byId);
   }

   @PutMapping("/{recruitId}")
   public  Mono<Result> updateById(@PathVariable("recruitId")String recruitId,@RequestBody TbRecruit recruit){
       recruit.setId(recruitId);
       boolean b = tbRecruitService.updateById(recruit);
       return success(b);
   }

   @DeleteMapping("/{recruitId}")
   public  Mono<Result> deleteById(@PathVariable("recruitId")String recruitId,@RequestBody TbRecruit recruit){
       recruit.setId(recruitId);
       boolean b = tbRecruitService.removeById(recruitId);
       return success(b);
   }

   @PostMapping("/search")
   public  Mono<Result> search(@RequestBody TbRecruit recruit){
       LambdaQueryWrapper<TbRecruit> tbRecruitLambdaQueryWrapper = getTbRecruitLambdaQueryWrapper(recruit);
       tbRecruitService.list(tbRecruitLambdaQueryWrapper);
       return success();
   }

    /**
     * 构造条件
     * @param recruit
     * @return
     */
    private LambdaQueryWrapper<TbRecruit> getTbRecruitLambdaQueryWrapper(@RequestBody TbRecruit recruit) {
        LambdaQueryWrapper<TbRecruit> tbRecruitLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (Objects.nonNull(recruit.getCondition())){
            tbRecruitLambdaQueryWrapper.like(TbRecruit::getCondition,recruit.getCondition());
        }
        if (Objects.nonNull(recruit.getEducation())){
            tbRecruitLambdaQueryWrapper.eq(TbRecruit::getEducation,recruit.getEducation());
        }
        return tbRecruitLambdaQueryWrapper;
    }

    @PostMapping("/search/{page}/{size}")
    public  Mono<Result> search(@PathVariable("page") Long page,@PathVariable("size") Long size,@RequestBody TbRecruit recruit){
        LambdaQueryWrapper<TbRecruit> tbRecruitLambdaQueryWrapper = getTbRecruitLambdaQueryWrapper(recruit);
        IPage<TbRecruit> pageResult = tbRecruitService.page(new Page<TbRecruit>().setCurrent(page).setSize(size), tbRecruitLambdaQueryWrapper);
        return success(pageResult);
    }

    @GetMapping("/search/{recommend}")
    public  Mono<Result> search(){
        List<TbRecruit> list = tbRecruitService.list(new LambdaQueryWrapper<TbRecruit>().eq(TbRecruit::getState, 1));
        return success(list);
    }

    @GetMapping("/search/newlist")
    public Mono<Result> getNew(){
        TbRecruit one = tbRecruitService.getOne(new LambdaQueryWrapper<TbRecruit>().orderByDesc(TbRecruit::getCreatetime).apply("limit 1"));
        return success(one);
    }




}
