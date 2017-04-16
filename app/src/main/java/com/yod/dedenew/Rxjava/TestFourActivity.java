package com.yod.dedenew.Rxjava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by twq on 2017/4/4.
 * 转换之map的练习
 */

public class TestFourActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        Observable.just("张三", "李斯特").map(new Func1<String, Student>() {
            @Override
            public Student call(String s) {
                Student sudent = new Student();
                sudent.name = s;
                return sudent;
            }
        }).subscribe(new Action1<Student>() {
            @Override
            public void call(Student student) {
                Log.d("twq", "call: " + student.toString());
            }
        });
    }
}
