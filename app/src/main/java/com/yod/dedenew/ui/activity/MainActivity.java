package com.yod.dedenew.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.MenuItem;

import com.yod.dedenew.R;
import com.yod.dedenew.ui.base.BaseActivity;
import com.yod.dedenew.ui.fragment.TestFragment;
import com.yod.dedenew.view.HackViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.viewPager)
    HackViewPager viewPager;
    @BindView(R.id.navigationView)
    BottomNavigationView navigationView;
    MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        TestAdapter adapter = new TestAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setIsPagingEnabled(true);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.add:
                        viewPager.setCurrentItem(0);
                        navigationView.setItemBackgroundResource( R.color.colorPrimaryDark);
                        break;
                    case R.id.delete:
                        viewPager.setCurrentItem(1);
                        navigationView.setItemBackgroundResource(R.color.material_red_600);
                        break;
                    case R.id.setting:
                        viewPager.setCurrentItem(2);
                        navigationView.setItemBackgroundResource(R.color.material_pink_200);
                        break;
                    case R.id.me:
                        viewPager.setCurrentItem(3);
                        navigationView.setItemBackgroundResource(R.color.material_green_500);
                        break;
                }
                return false;
            }
        });

    }

    public class TestAdapter extends FragmentStatePagerAdapter {
        List<TestFragment> list;

        public TestAdapter(FragmentManager fm) {
            super(fm);
            list = new ArrayList<>();
            list.add(TestFragment.newInstance("1111"));
            list.add(TestFragment.newInstance("22222222"));
            list.add(TestFragment.newInstance("322333"));
            list.add(TestFragment.newInstance("4444"));
        }

        @Override
        public Fragment getItem(int position) {

            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}
