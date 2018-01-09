package com.example.lianxi.addCart.model;

import com.example.lianxi.bean.AddCarBean;
import com.example.lianxi.net.OnNetListener;

/**
 * Created by asus on 2018/1/8.
 */

public interface IAddModel {
    public void getAddShow(OnNetListener<AddCarBean> onNetListener,String uid,int pid);
}
