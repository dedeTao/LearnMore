package com.yod.dedenew.Rxjava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by twq on 2017/4/4.
 * 测试被观察者的from、just方法
 */

public class TestThreeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        initJust();
    }

    private void initJust() {
        Observable.just("hello","world").subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.d("twq", "just onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.d("twq", "just + onError: ");
            }

            @Override
            public void onNext(String s) {
                Log.d("twq", "just onNext: " + s);
            }
        });
    }

    private void init() {
        String[] names = {"zhangsan","lisi","wanger"};
        Observable.from(names).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.d("twq", "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.d("twq", "onNext: " + s);
            }
        });
    }
}
