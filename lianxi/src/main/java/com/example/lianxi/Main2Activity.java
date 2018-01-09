package com.example.lianxi;

import android.content.Intent;
import android.os.Bundle;
import android.preference.TwoStatePreference;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lianxi.addCart.presenter.AddPresenter;
import com.example.lianxi.bean.GoodXiangBean;
import com.example.lianxi.net.MyApp;
import com.example.lianxi.xiangqing.presenter.XqPresenter;
import com.example.lianxi.xiangqing.view.XqActivity;
import com.facebook.drawee.view.SimpleDraweeView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener,XqActivity {

    private SimpleDraweeView mDeSdv;
    private TextView mDeTv1;
    /**
     * ￥
     */
    private TextView mDePrice;
    /**
     * 评价
     */
    private TextView mDePj;
    /**
     * 购物车
     */
    private Button mShowCart;
    /**
     * 加入购物车
     */
    private Button mAddcar;
    private GoodXiangBean.DataBean data;
    private int uid;
    private XqPresenter xiangPresenter;
    private AddPresenter addPresenter;
    public TwoStatePreference allCheckbox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        Intent intent = getIntent();
        String pid = intent.getStringExtra("pid");
        xiangPresenter = new XqPresenter(this);
        addPresenter = new AddPresenter(this);
        xiangPresenter.getData(pid);
        uid = MyApp.sp.getInt("uid", 0);

    }

    private void initView() {

        mDeSdv = (SimpleDraweeView) findViewById(R.id.de_sdv);
        mDeTv1 = (TextView) findViewById(R.id.de_tv1);
        mDePrice = (TextView) findViewById(R.id.de_price);
        mDePj = (TextView) findViewById(R.id.de_pj);
        mShowCart = (Button) findViewById(R.id.show_cart);
        mShowCart.setOnClickListener(this);
        mAddcar = (Button) findViewById(R.id.addcar);
        mAddcar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.show_cart:
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(intent);
                break;
            case R.id.addcar:
                addPresenter.setAdd(uid+"71",+data.getPid());
                break;
        }
    }

    @Override
    public void show(String str) {
        Toast.makeText(Main2Activity.this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNews(GoodXiangBean goodXiangBean) {
        data = goodXiangBean.getData();
        String images = this.data.getImages();
        String[] split = images.split("\\|");
        mDeSdv.setImageURI(split[0]);
        mDeTv1.setText(this.data.getTitle());
        mDePrice.setText("￥" + this.data.getPrice());
    }
}
