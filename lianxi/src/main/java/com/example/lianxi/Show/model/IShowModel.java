package com.example.lianxi.Show.model;

import com.example.lianxi.bean.BaseBean;
import com.example.lianxi.net.OnNetListener;

/**
 * Created by asus on 2018/1/8.
 */

public interface IShowModel {
    public void getList(OnNetListener<BaseBean> onNetListener);
}
