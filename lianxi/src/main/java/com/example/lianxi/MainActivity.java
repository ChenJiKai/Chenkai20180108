package com.example.lianxi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lianxi.Show.adapter.MyAdapter;
import com.example.lianxi.Show.presenter.SHowPresenter;
import com.example.lianxi.Show.view.IMainActivity;
import com.example.lianxi.bean.BaseBean;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainActivity {

    private RecyclerView mRecv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        SHowPresenter sHowPresenter = new SHowPresenter(this);
        sHowPresenter.getData();
        mRecv.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void getShow(BaseBean baseBean) {

        List<BaseBean.TuijianBean.ListBean> list = baseBean.getTuijian().getList();
        MyAdapter myAdapter = new MyAdapter(list, this);
        mRecv.setAdapter(myAdapter);

        myAdapter.setOnclick(new MyAdapter.Onclick() {
            @Override
            public void Onclik(String pid) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("pid",pid);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        mRecv = (RecyclerView) findViewById(R.id.recv);
    }
}
