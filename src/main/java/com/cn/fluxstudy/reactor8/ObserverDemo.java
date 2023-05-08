package com.cn.fluxstudy.reactor8;

import lombok.extern.slf4j.Slf4j;

import java.util.Observable;

@Slf4j
public class ObserverDemo extends Observable {

    public static void main(String[] args) {
        ObserverDemo observer = new ObserverDemo();
        //添加观察者
        observer.addObserver((o,arg)->{
                log.info("发生了变化!");
        });
        observer.addObserver((o,arg)->{
                log.info("收到被观察者通知, 准备改变!");
        });

        observer.setChanged();  //数据进行变化
        observer.notifyObservers();  //通知到其他人

    }
}
