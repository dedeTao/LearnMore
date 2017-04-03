package com.yod.dedenew.Rxjava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.yod.dedenew.R;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * Created by twq on 2017/4/4.
 * 自定义的观察者
 */

public class TestTwoActivity extends AppCompatActivity {

    public final String TAG = this.getClass().getSimpleName();
    private Action0 onCompleteAction;
    private Action1<Throwable> onErrorAction;
    private Action1<String> onNextAction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_one);
        initAction();
        initObserver();
    }

    private void initObserver() {
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("hello world");
                subscriber.onCompleted();
            }
        });
        //subscribe( )的方法参数顺序(onNext, onError, onCompleted)
        observable.subscribe(onNextAction, onErrorAction, onCompleteAction);
    }

    private void initAction() {
        onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d(TAG, "onNextAction call: " + s);
            }
        };

        onErrorAction = new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.d(TAG, "onErrorAction call: ");
            }
        };

        onCompleteAction = new Action0() {
            @Override
            public void call() {
                Log.d(TAG, "onCompleteAction call: ");
            }
        };
    }
}
