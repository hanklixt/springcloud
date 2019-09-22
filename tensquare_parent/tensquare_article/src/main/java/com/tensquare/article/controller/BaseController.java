package com.tensquare.article.controller;

import entity.Result;
import reactor.core.publisher.Mono;
import resultenum.ResultEnum;
import util.HttpResultUtils;

public class BaseController {
    public Mono<Result> success(Object object) {
        return  Mono.create(x->x.success(HttpResultUtils.success(object)));
    }
    public Mono<Result> error(Object object, ResultEnum resultEnum){

        return Mono.create(x->x.success(HttpResultUtils.error(object,resultEnum)));
    }
    public Mono<Result> success() {
        return  Mono.create(x->x.success(HttpResultUtils.success()));
    }
}
