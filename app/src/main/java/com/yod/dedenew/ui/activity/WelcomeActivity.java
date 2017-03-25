package com.yod.dedenew.ui.activity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.yod.dedenew.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Create by twq on 2016/11/13 21:24
 * Email 593912993@qq.com
 */
public class WelcomeActivity extends AppCompatActivity {
    @BindView(R.id.logo_outer_iv)
    ImageView logoOuterIv;
    @BindView(R.id.logo_inner_iv)
    ImageView logoInnerIv;
    @BindView(R.id.app_name_tv)
    TextView appNameTv;
    boolean isShowingRubberEffect = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_top_in);
        logoInnerIv.setAnimation(animation);

        startLogoOuterAndAppName();
    }

    private void startLogoOuterAndAppName() {
        final ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);
        valueAnimator.setDuration(1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float fraction = animation.getAnimatedFraction();
                if (fraction > 0.8 && !isShowingRubberEffect) {
                    isShowingRubberEffect = true;
                    startMainActivity();
                } else if (fraction > 0.95) {

                }
            }
        });
        valueAnimator.start();
    }

    private void startMainActivity() {
        /*Observable.timer(1000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                        finish();
                    }
                });*/
    }
}
