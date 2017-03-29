package com.yod.dedenew.daggertest_two;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

/**
 * Created by twq on 2017/3/29.
 */

public class DaggerTestTwoActivity extends AppCompatActivity {
    @Inject
    People people;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PeopleComponent component = DaggerPeopleComponent.builder().peopleModule(new PeopleModule(this)).build();
        component.inject(this);
    }
}
