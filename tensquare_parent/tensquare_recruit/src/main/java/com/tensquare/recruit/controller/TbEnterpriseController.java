package com.tensquare.recruit.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tensquare.recruit.entity.TbEnterprise;
import com.tensquare.recruit.service.ITbEnterpriseService;
import entity.Result;
import exception.TensquareException;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Mono;
import resultenum.ResultEnum;
import util.IdWorker;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 企业 前端控制器
 * </p>
 *
 * @author lxt
 * @since 2019-09-22
 */
@RestController
@RequestMapping("/enterprise")
public class TbEnterpriseController extends BaseController{

    @Autowired
    private ITbEnterpriseService enterpriseService;

    @Autowired
    private IdWorker idWorker;

    @PostMapping("/add")
    public Mono<Result> addEnterprise(@RequestBody TbEnterprise enterprise){
        boolean save = enterpriseService.save(enterprise);
        return success(save);
    }

    @GetMapping("/getAll")
    public Mono<Result> listEnterprise(){
        List<TbEnterprise> list = enterpriseService.list();
        return success(list);
    }
    @GetMapping("/{enterpriseId}")
    public  Mono<Result> findById(@PathVariable("enterpriseId") String enterpriseId){
        TbEnterprise byId = enterpriseService.getById(enterpriseId);
        return success(byId);
    }
    @SneakyThrows
    @PutMapping("/{enterpriseId}")
    public Mono<Result> updateById(@Valid @RequestBody TbEnterprise tbEnterprise, @PathVariable("enterpriseId") @NotBlank String enterpriseId, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new TensquareException(ResultEnum.REQUEST_PARAM_ERROR.getMessage(),ResultEnum.REQUEST_PARAM_ERROR.getCode());
        }
        tbEnterprise.setId(enterpriseId);
        boolean b = enterpriseService.updateById(tbEnterprise);
        return success(b);
    }
    @DeleteMapping("/{enterpriseId}")
    public Mono<Result> deleteById(@PathVariable("enterpriseId")String enterpriseId){
        boolean b = enterpriseService.removeById(enterpriseId);
        return success(b);
    }

    @PostMapping("/search")
    public  Mono<Result> search(@RequestBody TbEnterprise enterprise){
        LambdaQueryWrapper<TbEnterprise> enterpriseWrapper = getEnterpriseWrapper(enterprise);
        List<TbEnterprise> list = enterpriseService.list(enterpriseWrapper);
        return success(list);
    }

    /**
     * 构造查询条件
     * @param enterprise
     * @return
     */
    private LambdaQueryWrapper<TbEnterprise> getEnterpriseWrapper(@RequestBody TbEnterprise enterprise) {
        LambdaQueryWrapper<TbEnterprise> tbEnterpriseLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (Objects.nonNull(enterprise.getAddress())){
            tbEnterpriseLambdaQueryWrapper.like(TbEnterprise::getAddress,enterprise.getAddress());
        }
        if (Objects.nonNull(enterprise.getIshot())){
            tbEnterpriseLambdaQueryWrapper.eq(TbEnterprise::getIshot,enterprise.getIshot());
        }
        return  tbEnterpriseLambdaQueryWrapper;
    }
    @GetMapping("search/hotlist")
    public  Mono<Result> searchHost(){
        LambdaQueryWrapper<TbEnterprise> tbEnterpriseLambdaQueryWrapper = new LambdaQueryWrapper<>();
        tbEnterpriseLambdaQueryWrapper.eq(TbEnterprise::getIshot,1);
        List<TbEnterprise> list = enterpriseService.list(tbEnterpriseLambdaQueryWrapper);
        return success(list);
    }

    @PostMapping("/search/{page}/{size}")
    public Mono<Result> searchPage(@PathVariable("page") Long page,@PathVariable("size") Long size,@RequestBody TbEnterprise enterprise){
        LambdaQueryWrapper<TbEnterprise> enterpriseWrapper = getEnterpriseWrapper(enterprise);
        IPage<TbEnterprise> pageResult = enterpriseService.page(new Page<TbEnterprise>().setCurrent(page).setSize(size), enterpriseWrapper);
        return success(pageResult);
    }


}
