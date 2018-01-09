package com.example.lianxi.Show.model;

import com.example.lianxi.bean.BaseBean;
import com.example.lianxi.net.OnNetListener;
import com.example.lianxi.net.RetrofitHelper;
import com.example.lianxi.net.ServerApi;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by asus on 2018/1/8.
 */

public class ShowModel implements IShowModel {
    @Override
    public void getList(final OnNetListener<BaseBean> onNetListener) {
        ServerApi serverApi = RetrofitHelper.getServerApi();
        serverApi.shou()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BaseBean>(){

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(BaseBean baseBean) {

                        onNetListener.onSuccess(baseBean);
                    }
                });

    }
}
