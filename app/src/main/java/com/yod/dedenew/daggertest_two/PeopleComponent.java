package com.yod.dedenew.daggertest_two;

import dagger.Component;

/**
 * Created by twq on 2017/3/29.
 */
@Component(modules = PeopleModule.class)
public interface PeopleComponent {
    public void inject(DaggerTestTwoActivity activity);
}
