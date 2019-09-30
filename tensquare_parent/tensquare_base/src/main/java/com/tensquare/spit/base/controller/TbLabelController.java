package com.tensquare.spit.base.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tensquare.spit.base.entity.TbLabel;
import com.tensquare.spit.base.service.ITbLabelService;
import entity.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Mono;

import java.util.Objects;

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
    public Mono<Result> updateById(@PathVariable("id") String id,@RequestBody  TbLabel  label){
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
    public Mono<Result> search(@RequestBody TbLabel tbLabel){
        LambdaQueryWrapper<TbLabel> tbLabelLambdaQueryWrapper = new LambdaQueryWrapper<>();
        getLabelWrapper(tbLabel, tbLabelLambdaQueryWrapper);
        return success(tbLabelService.list(tbLabelLambdaQueryWrapper));
    }

    /**
     * 构造查询条件
     * @param tbLabel
     * @param tbLabelLambdaQueryWrapper
     */
    private void getLabelWrapper(@RequestBody TbLabel tbLabel, LambdaQueryWrapper<TbLabel> tbLabelLambdaQueryWrapper) {
        if (Objects.nonNull(tbLabel.getId())){
            tbLabelLambdaQueryWrapper.eq(TbLabel::getId,tbLabel.getId());
        }
        if (Objects.nonNull(tbLabel.getLabelname())){
            tbLabelLambdaQueryWrapper.like(TbLabel::getLabelname,tbLabel.getLabelname());
        }
        if (Objects.nonNull(tbLabel.getCount())){
            tbLabelLambdaQueryWrapper.eq(TbLabel::getCount,tbLabel.getCount());
        }
        if (Objects.nonNull(tbLabel.getState())){
            tbLabelLambdaQueryWrapper.eq(TbLabel::getState,tbLabel.getState());
        }
        if (Objects.nonNull(tbLabel.getRecommend())){
            tbLabelLambdaQueryWrapper.eq(TbLabel::getRecommend,tbLabel.getRecommend());
        }
    }

    @PostMapping("search/{pageNo}/{pageSize}")
    public Mono<Result>searchPage(@PathVariable("pageNo") Long pageNo,@PathVariable("pageSize") Long pageSize,@RequestBody TbLabel tbLabel){
        LambdaQueryWrapper<TbLabel> tbLabelLambdaQueryWrapper = new LambdaQueryWrapper<>();
        getLabelWrapper(tbLabel, tbLabelLambdaQueryWrapper);
        return success(tbLabelService.page(new Page<TbLabel>().setCurrent(pageNo).setSize(pageSize),tbLabelLambdaQueryWrapper));
    }
    @PostMapping
    public Mono<Result> save(TbLabel tbLabel){
        return success(tbLabelService.save(tbLabel));
    }


}
