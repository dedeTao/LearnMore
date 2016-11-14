package com.yod.dedenew.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yod.dedenew.ui.base.BaseFragment;

/**
 * Create by twq on 2016/11/14 02:59
 * Email 593912993@qq.com
 */
public class TestFragment extends BaseFragment {
    public static TestFragment newInstance(String info) {
        Bundle args = new Bundle();
        TestFragment fragment = new TestFragment();
        args.putString("info", info);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView textView = new TextView(getContext());
        textView.setText(getArguments().getString("info"));
        textView.setTextSize(34);
        return textView;
    }
}
