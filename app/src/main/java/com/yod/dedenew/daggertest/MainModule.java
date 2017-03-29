package com.yod.dedenew.daggertest;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by twq on 2017/3/28.
 */
@Module
public class MainModule {
    @Provides // 关键字，标明该方法提供依赖对象
    @Singleton //表明只可以创建一个对象,对应的MainComponent也需要设置 @Singleton
    Person providerPerson() {
        //提供Person对象
        return new Person();
    }
}
