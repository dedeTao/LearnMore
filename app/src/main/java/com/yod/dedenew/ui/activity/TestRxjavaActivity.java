package com.yod.dedenew.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yod.dedenew.R;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by twq on 2017/3/25.
 */

public class TestRxjavaActivity extends AppCompatActivity {

    private Observable<String> observable;
    private Subscriber<String> subscriber;
    private int count;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initRxjava();
        initView();
    }

    private void initView() {
        TextView textview = (TextView) findViewById(R.id.text);
        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                observable.subscribe(subscriber);//订阅
            }
        });

        TextView textView2 = (TextView) findViewById(R.id.text2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.just("just1", "just2");//依次发送"just1"和"just2"
            }
        });

        TextView textView3 = (TextView) findViewById(R.id.text3);
//        RxView
    }

    private void initRxjava() {
        //观察者
        observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("调用");
                subscriber.onCompleted();
            }
        });
        //订阅者
        subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                count++;
                Toast.makeText(TestRxjavaActivity.this, "已经订阅-" + count, Toast.LENGTH_LONG).show();
                Log.d("twq", "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.d("twq", "onNext: " + s);
            }
        };

    }
}
