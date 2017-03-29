package com.yod.dedenew.daggertest;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by twq on 2017/3/28.
 */
@Singleton
@Component(modules = MainModule.class)  // 作为桥梁，沟通调用者和依赖对象库
public interface MainComponent {
    //定义注入的方法
    void inject(DaggerTestActivity activity);
}
