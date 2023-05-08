package com.cn.fluxstudy.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestReactor {
    public static void main(String[] args) {

        //just方法直接声明
        Flux.just(1,2,3,4);
        Mono.just(1);

        //其他声明方式
        Integer[] array = new Integer[] {
            1,2,3,4
        };
        Flux.fromArray(array);

        List<Integer> list = Arrays.asList(1,2,3,4);
        Flux.fromIterable(list);

        Stream<Integer> strem = list.stream();
        Flux.fromStream(strem);

        //just()：创建Flux序列，并声明数据流，
        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4);//整形
        //subscribe()：订阅Flux序列，只有进行订阅后才回触发数据流，不订阅就什么都不会发生
        integerFlux.subscribe((e)->{
            System.out.println(e);
        });

        Flux<String> stringFlux = Flux.just("hello", "world");//字符串
        stringFlux.subscribe(System.out::println);

        //fromArray(),fromIterable()和fromStream()：可以从一个数组、Iterable 对象或Stream 对象中创建Flux序列
        Integer[] as = {1,2,3,4};
        Flux.fromArray(as).subscribe(System.out::println);

        List<Integer> integers = Arrays.asList(as);
        Flux.fromIterable(integers).subscribe(System.out::println);

        Stream<Integer> stream = integers.stream();
        Flux.fromStream(stream).subscribe(System.out::println);


    }
}
