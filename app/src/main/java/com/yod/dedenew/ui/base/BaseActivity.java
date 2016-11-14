package com.yod.dedenew.ui.base;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.yod.dedenew.R;

/**
 * Create by twq on 2016/11/13 21:38
 * Email 593912993@qq.com
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initStatusBar();
    }

    /**
     * 初始化StatusBar,兼容4.4
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void initStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(R.color.colorPrimary);
        }
    }
}
