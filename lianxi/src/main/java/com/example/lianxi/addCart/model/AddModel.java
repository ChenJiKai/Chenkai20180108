package com.example.lianxi.addCart.model;

import com.example.lianxi.bean.AddCarBean;
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

public class AddModel implements IAddModel {
    @Override
    public void getAddShow(final OnNetListener<AddCarBean> onNetListener, String uid, int pid) {
        ServerApi serverApi = RetrofitHelper.getServerApi();
        serverApi.addCart(uid,pid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AddCarBean>(){

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        onNetListener.onFailure((Exception) e);
                    }

                    @Override
                    public void onNext(AddCarBean addCarBean) {

                        onNetListener.onSuccess(addCarBean);
                    }
                });
    }
}
