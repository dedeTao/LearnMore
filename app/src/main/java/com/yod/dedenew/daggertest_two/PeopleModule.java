package com.yod.dedenew.daggertest_two;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by twq on 2017/3/29.
 * module注解表示这里提供依赖对象
 */
@Module
public class PeopleModule {
    private Context context;

    public PeopleModule(Context context) {
        this.context = context;
    }

    /**
     * 这里是为providePeople提供参数的方法
     *
     * @return
     */
    @Provides
    public Context provideContext() {
        return this.context;
    }

    /**
     * 这里是依赖注入提供方法  方法命名规则是provide开头 并加provide注解
     *
     * @param context
     * @return
     */
    @Provides
    public People providePeople(Context context) {
        return new People(context);
    }
}
