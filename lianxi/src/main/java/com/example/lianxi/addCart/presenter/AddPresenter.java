package com.example.lianxi.addCart.presenter;

import com.example.lianxi.addCart.model.AddModel;
import com.example.lianxi.addCart.model.IAddModel;
import com.example.lianxi.addCart.view.AddActivity;
import com.example.lianxi.bean.AddCarBean;
import com.example.lianxi.net.OnNetListener;
import com.example.lianxi.xiangqing.view.XqActivity;

/**
 * Created by asus on 2018/1/8.
 */

public class AddPresenter {
    private IAddModel iAddModel;
    private XqActivity xqActivity;

    public AddPresenter(XqActivity xqActivity) {
        this.xqActivity = xqActivity;
        this.iAddModel=new AddModel();
    }

    public void setAdd(String uid, int pid){
        iAddModel.getAddShow(new OnNetListener<AddCarBean>() {
            @Override
            public void onSuccess(AddCarBean addCarBean) {
                xqActivity.show(addCarBean.getMsg());

            }

            @Override
            public void onFailure(Exception e) {

            }
        },uid,pid);

    }
}
