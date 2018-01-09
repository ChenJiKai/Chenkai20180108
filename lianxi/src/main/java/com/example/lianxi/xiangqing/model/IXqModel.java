package com.example.lianxi.xiangqing.model;


import com.example.lianxi.bean.GoodXiangBean;
import com.example.lianxi.net.OnNetListener;

/**
 * Created by asus on 2018/1/5.
 */

public interface IXqModel {
    public void getShow(OnNetListener<GoodXiangBean> onNetListener, String pid);
}
