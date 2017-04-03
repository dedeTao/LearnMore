package com.yod.dedenew.Rxjava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.yod.dedenew.R;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * Created by twq on 2017/4/1.
 * 最简单的模式
 */

public class TestOneActivity extends AppCompatActivity {
    public final String TAG = this.getClass().getSimpleName();
    private Observer<String> observer;
    private Subscriber<String> subscriber;
    private Observable<String> observable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_one);
        CreateObserver();
        createSubscribe();
        initView();

    }

    private void initView() {
        TextView text_Observer = (TextView) findViewById(R.id.text_Observer);
        TextView text_Subscriber = (TextView) findViewById(R.id.text_Subscriber);
        text_Observer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                observable.subscribe(observer);
            }
        });
        text_Subscriber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                observable.subscribe(subscriber);
            }
        });
    }

    /**
     * 创建被观察者
     */
    private void createSubscribe() {
        observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("世上只有妈妈好");
                subscriber.onNext("世上只有爸爸好");
                subscriber.onCompleted();
            }
        });
    }

    /**
     * 创建观察者
     */
    private void CreateObserver() {
        //创建观察者
        observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "observer onError: ");
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "observer onNext: -- " + s);
            }
        };
        //创建观察者
        subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "subscriber onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "subscriber onError: ");
            }

            @Override
            public void onNext(String str) {
                Log.d(TAG, "subscriber onNext: -- " + str);
            }
        };
    }
}
