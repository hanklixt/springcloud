package com.tensquare.complaints.controller;

import com.tensquare.complaints.entity.Complain;
import com.tensquare.complaints.service.ComplainService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import resultenum.ResultEnum;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/spit")
public class ComplainController extends BaseController{
   @Autowired
   private ComplainService spitService;

   @Autowired
   private RedisTemplate redisTemplate;

    @PostMapping
    public Mono<Result> add(@RequestBody Complain spit){
        spitService.save(spit);
        return success() ;
    }

    @GetMapping
    public Mono<Result> getAll(){
        List<Complain> all = spitService.findAll();
        return success(all);
    }
    @GetMapping("/{spitId}")
    public Mono<Result> findById(@PathVariable("spitId") String spitId){
        Optional<Complain> byId = spitService.findById(spitId);
        Complain spit = byId.get();
        return success(spit);
    }
    @PutMapping("/{spitId}")
    public Mono<Result> updateById(@PathVariable("spitId")String spitId, @RequestBody Complain spit){
        spit.set_id(spitId);
        spitService.update(spit);
        return success();
    }
    @DeleteMapping("/{spitId}")
    public Mono<Result> removeById(@PathVariable("spitId")String spitId){
        spitService.removeById(spitId);
        return success();
    }

    @PutMapping("/thumbup/{spitId}")
    public Mono<Result> thumbupAdd(@PathVariable("spitId") String spitId){
        String userId="1";
        Object obj = redisTemplate.opsForValue().get("spit:" + userId);
        if (!ObjectUtils.isEmpty(obj)){
            return error(ResultEnum.NOT_REPEAT);
        }
        spitService.updateThumpBetter(spitId);
        redisTemplate.opsForValue().set("spit:"+userId,1);
        return success();
    }

    @GetMapping(value="/comment/{parentId}/{page}/{size}")
    public Mono<Result> findByParentid(@PathVariable String parentId,
                                       @PathVariable int page, @PathVariable int size) {
        Page<Complain> byParentId = spitService.findByParentId(parentId, page, size);
        return success(byParentId);
    }

    }
