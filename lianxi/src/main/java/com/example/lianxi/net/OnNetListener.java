package com.example.lianxi.net;

/**
 * Created by wsq on 2017/12/12.
 * 回调接口
 */

public interface OnNetListener<T> {
    public void onSuccess(T t);
    public void onFailure(Exception e);
}
