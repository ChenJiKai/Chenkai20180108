package com.example.lianxi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.lianxi.bean.CartBean;
import com.example.lianxi.goueuche.adapter.MyAdapter;
import com.example.lianxi.goueuche.eventbus.MessageEvent;
import com.example.lianxi.goueuche.eventbus.PriceAndCountEvent;
import com.example.lianxi.goueuche.presenter.GetCardPresenter;
import com.example.lianxi.goueuche.view.ICartFragment;
import com.example.lianxi.net.MyApp;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener,ICartFragment {
    private GetCardPresenter presenter;
    private MyAdapter adapter;
    private View view;
    /**
     * c
     */
    private TextView mFan;
    /**
     * 编辑
     */
    private TextView mBj;
    private ExpandableListView mElv;
    /**
     * 全选
     */
    private CheckBox mCheckAll;
    /**
     * 分享宝贝
     */
    private Button mShare;
    /**
     * 移到收藏栏
     */
    private Button mFile;
    /**
     * 删除
     */
    private Button mDele;
    private LinearLayout mCaozuo;
    /**
     * 价钱
     */
    private TextView mPriceAll;
    /**
     * 结算
     */
    private Button mJs;
    private RelativeLayout mJiesuan;
    private   List<List<CartBean.DataBean.ListBean>> lists = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
        EventBus.getDefault().register(this);
        presenter = new GetCardPresenter(this);
        int id = MyApp.sp.getInt("uid", 71);
        String token = MyApp.sp.getString("token", "");
        presenter.getCarts(id+"",token);
        mCaozuo.setVisibility(View.GONE);
    }

    @Override
    public void onShow(CartBean cartBean) {
        Toast.makeText(getApplicationContext(),cartBean.getCode(), Toast.LENGTH_SHORT).show();
        List<CartBean.DataBean> data = cartBean.getData();

        for (int i = 0; i < data.size(); i++) {
            data.get(i).setBj("编辑");
            data.get(i).setWc("完成");
            List<CartBean.DataBean.ListBean> list = data.get(i).getList();
            lists.add(list);
        }
        adapter = new MyAdapter(this, data, lists);
        mElv.setAdapter(adapter);
        for (int i=0; i<data.size(); i++)
        {
            mElv.expandGroup(i);
        }


    }

    private void initView() {
        mFan = (TextView) findViewById(R.id.fan);
        mBj = (TextView) findViewById(R.id.bj);
        mElv = (ExpandableListView) findViewById(R.id.elv);
        mCheckAll = (CheckBox) findViewById(R.id.check_all);
        mShare = (Button) findViewById(R.id.share);
        mShare.setOnClickListener(this);
        mFile = (Button) findViewById(R.id.file);
        mFile.setOnClickListener(this);
        mDele = (Button) findViewById(R.id.dele);
        mDele.setOnClickListener(this);
        mCaozuo = (LinearLayout) findViewById(R.id.caozuo);
        mPriceAll = (TextView) findViewById(R.id.price_all);
        mJs = (Button) findViewById(R.id.js);
        mJs.setOnClickListener(this);
        mJiesuan = (RelativeLayout) findViewById(R.id.jiesuan);
        mCheckAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //changeAllListCbState
                adapter.changeAllListCbState(mCheckAll.isChecked());
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.share:
                break;
            case R.id.file:
                break;
            case R.id.dele:
                break;
            case R.id.js:
                break;
        }
    }
    @Subscribe
    public void onMessageEvent(MessageEvent event) {
        mCheckAll.setChecked(event.isChecked());
    }

    @Subscribe
    public void onMessageEvent(PriceAndCountEvent event) {
        mPriceAll.setText("结算(" + event.getCount() + ")"+event.getPrice() + "");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


}

