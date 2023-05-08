package com.cn.fluxstudy.reactor;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.HashMap;


@Slf4j
public class ReactorTest {
    public static void main(String[] args) {

        //Flux.range(1,30).subscribe(System.out ::println);
        //Flux.range(1, 100).buffer(20).subscribe(System.out::println);
        //Flux.intervalMillis(100).bufferMillis(1001).take(2).toStream().forEach(System.out::println);
        //Flux.range(1, 10).bufferUntil(i -> i%2 == 0).subscribe(System.out::println);
        //Flux.range(1, 10).bufferWhile(i -> i%2 == 0).subscribe(System.out::println);

        //filter
        //Flux.range(1, 10).filter(i -> i%2 == 0).subscribe(System.out::println);

        //zipWith
        //Flux.just("a", "b").zipWith(Flux.just("c", "d")).subscribe(System.out::println);
        //Flux.just("a", "b").zipWith(Flux.just("c", "d"), (s1, s2) -> String.format("%s-%s", s1, s2)).subscribe(System.out::println);

        //Flux.range(1, 1000).take(10).subscribe(System.out::println);
        //Flux.range(1, 1000).takeLast(10).subscribe(System.out::println);
        //Flux.range(1, 1000).takeWhile(i -> i < 10).subscribe(System.out::println);
        //Flux.range(1, 1000).takeUntil(i -> i == 10).subscribe(System.out::println);

        //Flux.just(1, 2).concatWith(Mono.error(new IllegalStateException())).subscribe(System.out::println, System.err::println);

        //Flux.just(1, 2).concatWith(Mono.error(new IllegalStateException())).onErrorReturn(0).subscribe(System.out::println);

        //Flux.create(sink -> {
        //    log.info("-----"+Thread.currentThread().getName());
        //    sink.next(Thread.currentThread().getName());
        //    sink.complete();
        //}).publishOn(Schedulers.single())
        //        .map(x ->  String.format("[%s] %s", Thread.currentThread().getName(), x))
        //        .publishOn(Schedulers.elastic())
        //        .map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
        //        .subscribeOn(Schedulers.parallel())
        //        .toStream()
        //        .forEach(System.out::println);

        Flux.range(1, 2).log("Range").subscribe(System.out::println);



    }
}

