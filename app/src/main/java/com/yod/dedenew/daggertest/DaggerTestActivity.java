package com.yod.dedenew.daggertest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import javax.inject.Inject;

/**
 * Created by twq on 2017/3/28.
 */

public class DaggerTestActivity extends AppCompatActivity {

    @Inject   //标明需要注入的对象
    Person person;
    @Inject
    Person person2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainComponent component = DaggerMainComponent.builder().mainModule(new MainModule()).build();
        //注入
        component.inject(this);
        Log.i("twq","person = "+ person.toString()+"; person2 = "+ person2.toString());
    }
}
