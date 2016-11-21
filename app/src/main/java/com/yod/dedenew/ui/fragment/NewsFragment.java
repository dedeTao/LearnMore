package com.yod.dedenew.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.yod.dedenew.R;
import com.yod.dedenew.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Create by twq on 2016/11/15 01:56
 * Email 593912993@qq.com
 */
public class NewsFragment extends BaseFragment {

    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.add_channel_iv)
    ImageView addChannelIv;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    private Context context;

    public static NewsFragment newInstance(String info) {
        Bundle args = new Bundle();
        NewsFragment fragment = new NewsFragment();
        args.putString("info", info);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        context = getContext();
        View view = View.inflate(context, R.layout.fragment_news, null);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        viewPager.setAdapter(new ViewpagerAdapter(getFragmentManager()));
        tabs.setupWithViewPager(viewPager);
    }

    public class ViewpagerAdapter extends FragmentStatePagerAdapter {

        String[] titles = {"haha", "haha", "haha", "haha", "haha"};

        public ViewpagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return TestFragment.newInstance(position + "");
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }


    }
}
