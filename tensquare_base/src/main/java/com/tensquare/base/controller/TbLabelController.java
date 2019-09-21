package com.tensquare.base.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tensquare.base.entity.TbLabel;
import com.tensquare.base.service.ITbLabelService;
import entity.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Mono;

/**
 * <p>
 * 标签 前端控制器
 * </p>
 *
 * @author lxt
 * @since 2019-09-21
 */
@RestController
@RequestMapping("/label")
public class TbLabelController extends BaseController {

    @Autowired
    private ITbLabelService tbLabelService;


    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @GetMapping("/{labelId}")
    public Mono<Result> findById(@PathVariable("labelId") String labelId){
        TbLabel label = tbLabelService.getById(labelId);
        return this.success(label);
    }
    @PostMapping("/{id}")
    public Mono<Result> updateById(@PathVariable("id") String id,TbLabel  label){
       label.setId(id);
        tbLabelService.updateById(label);
        return success();
    }
    @GetMapping("/list")
    public  Mono<Result> findAll(){
        return success(tbLabelService.list());
    }

    @DeleteMapping("/{labelId}")
    public Mono<Result> deleteById(@PathVariable("labelId") String labelId){
        return success(tbLabelService.removeById(labelId));
    }
    @PostMapping("/search")
    public Mono<Result> search(){
        return success(tbLabelService.list());
    }
    @PostMapping("search/{pageNo}/{pageSize}")
    public Mono<Result>searchPage(@PathVariable("pageNo") Long pageNo,@PathVariable("/pageSize") Long pageSize){
        return success(tbLabelService.page(new Page<TbLabel>().setCurrent(pageNo).setSize(pageSize)));
    }
    @PostMapping
    public Mono<Result> save(TbLabel tbLabel){
        return success(tbLabelService.save(tbLabel));
    }


}
