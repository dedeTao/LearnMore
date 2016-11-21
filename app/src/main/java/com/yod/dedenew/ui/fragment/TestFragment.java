package com.yod.dedenew.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.yod.dedenew.R;
import com.yod.dedenew.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Create by twq on 2016/11/14 02:59
 * Email 593912993@qq.com
 */
public class TestFragment extends BaseFragment {

    @BindView(R.id.listview)
    ListView listview;
    private Context context;

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
        context = getContext();
        View view = View.inflate(context, R.layout.fragment_test, null);
        ButterKnife.bind(this, view);
        String[] strings = {"img","title","info","time"};//Map的key集合数组
        int[] ids = {R.id.img,R.id.title,R.id.info,R.id.time};//对应布局文件的id
        SimpleAdapter simpleAdapter = new SimpleAdapter(context,
                getData(), R.layout.activity_weixin_item, strings, ids);
        listview.setAdapter(simpleAdapter);//绑定适配器
        return view;
    }
    // 初始化一个List
    private List<HashMap<String, Object>> getData() {
        // 新建一个集合类，用于存放多条数据
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map = null;
        for (int i = 1; i <= 40; i++) {
            map = new HashMap<String, Object>();
            map.put("title", "人物" + i);
            map.put("time", "9月20日");
            map.put("info", "我通过了你的好友验证请求，现在我们可以开始对话啦");
            map.put("img", R.mipmap.setting);
            list.add(map);
        }
        return list;
    }
}
