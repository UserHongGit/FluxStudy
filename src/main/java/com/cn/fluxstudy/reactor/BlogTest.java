package com.cn.fluxstudy.reactor;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BlogTest {
    public static void main(String[] args) throws Exception{
        //Flux<String> map = Flux.just("aa", "bb").map(s -> {
        //    s = s.toUpperCase();
        //    log.info(s);
        //    return s;
        //});
        //
        //map.subscribeOn(Schedulers.elastic())
        //.subscribe(e->{
        //    log.info("-----"+e);
        //});

        Flux.just("aa","bb","cc")
                .subscribeOn(Schedulers.elastic())
                .map(e ->{
                    //int a = 10/0;

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                    log.info("del ---- " + e);
                    return Mono.just(e);
                })
                .publishOn(Schedulers.elastic())
                .subscribe(e ->{
                    log.info("e.class:{}, e:{},   e.block:{}",e.getClass(),e,e.block());
                },err ->{
                    log.error("err happen :{}",err.getMessage());
                });

        TimeUnit.SECONDS.sleep(5);
        log.info("main -- end");




    }
}
