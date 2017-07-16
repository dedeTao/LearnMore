package com.yod.dedenew.view;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by twq on 2017/7/5.
 */

public class CircleMoveView extends View {

    Paint piant = new Paint();

    public CircleMoveView(Context context) {
        super(context);
    }

    public CircleMoveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleMoveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
