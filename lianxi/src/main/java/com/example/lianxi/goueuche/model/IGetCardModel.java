package com.example.lianxi.goueuche.model;
import com.example.lianxi.bean.CartBean;
import com.example.lianxi.net.OnNetListener;

/**
 * Created by Administrator on 2017/12/19.
 */

public interface IGetCardModel{
    public void getCard(String uid,String token, OnNetListener<CartBean> onNetListener);
}
