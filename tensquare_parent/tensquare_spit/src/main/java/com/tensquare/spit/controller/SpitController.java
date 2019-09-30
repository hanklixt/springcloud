//package com.tensquare.spit.controller;
//
//import com.tensquare.spit.entity.Spit;
//import com.tensquare.spit.service.SpitService;
//import entity.Result;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import reactor.core.publisher.Mono;
//import sun.security.provider.ConfigFile;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@CrossOrigin
//@RequestMapping("/spit")
//public class SpitController  extends BaseController{
//    @Autowired
//    private SpitService spitService;
//
//    @PostMapping
//    public Mono<Result> add(@RequestBody Spit spit){
//        spitService.save(spit);
//        return success() ;
//    }
//
//    @GetMapping
//    public Mono<Result> getAll(){
//        List<Spit> all = spitService.findAll();
//        return success(all);
//    }
//    @GetMapping("/{spitId}")
//    public Mono<Result> findById(@PathVariable("spitId") String spitId){
//        Optional<Spit> byId = spitService.findById(spitId);
//        Spit spit = byId.get();
//        return success(spit);
//    }
//    @PutMapping("/{spitId}")
//    public Mono<Result> updateById(@PathVariable("spitId")String spitId, @RequestBody Spit spit){
//        spit.set_id(spitId);
//        spitService.update(spit);
//        return success();
//    }
//    @DeleteMapping("/{spitId}")
//    public Mono<Result> removeById(@PathVariable("spitId")String spitId){
//        spitService.removeById(spitId);
//        return success();
//    }
//
////    @PutMapping("/thumbup/{spitId}")
////    public Mono<Result> thumbupAdd(@PathVariable("spitId") String spitId){
////
////    }
//}
