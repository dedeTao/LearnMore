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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initRxjava();
        TextView textview = (TextView) findViewById(R.id.text);
        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                observable.subscribe(subscriber);//订阅
            }
        });
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
                Toast.makeText(TestRxjavaActivity.this, "已经订阅", Toast.LENGTH_LONG).show();
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
