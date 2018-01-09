package com.example.lianxi.xiangqing.model;


import com.example.lianxi.bean.GoodXiangBean;
import com.example.lianxi.net.OnNetListener;
import com.example.lianxi.net.RetrofitHelper;
import com.example.lianxi.net.ServerApi;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by asus on 2018/1/5.
 */

public class XqModel implements IXqModel {
    @Override
    public void getShow(final OnNetListener<GoodXiangBean> onNetListener, String pid) {

        ServerApi serverApi = RetrofitHelper.getServerApi();
        serverApi.detail(pid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GoodXiangBean>(){

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(GoodXiangBean goodXiangBean) {

                        onNetListener.onSuccess(goodXiangBean);

                    }
                });

    }
}
