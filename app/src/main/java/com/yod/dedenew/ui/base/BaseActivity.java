package com.yod.dedenew.ui.base;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.yod.dedenew.R;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * Create by twq on 2016/11/13 21:38
 * Email 593912993@qq.com
 */
public class BaseActivity extends SupportActivity {
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
