package com.example.lianxi.goueuche.model;

import android.util.Log;

import com.example.lianxi.bean.CartBean;
import com.example.lianxi.bean.GoodXiangBean;
import com.example.lianxi.net.OnNetListener;
import com.example.lianxi.net.RetrofitHelper;
import com.example.lianxi.net.ServerApi;

import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import rx.Subscriber;


/**
 * Created by Administrator on 2017/12/19.
 */

public class GetCardModel implements IGetCardModel {

    @Override
    public void getCard(String uid, String token, final OnNetListener<CartBean> onNetListener) {
        ServerApi serverApi = RetrofitHelper.getServerApi();
        serverApi.cart(uid,token)
                .subscribeOn(rx.schedulers.Schedulers.io())
                .observeOn(rx.android.schedulers.AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CartBean>(){

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(CartBean cartBean) {

                        onNetListener.onSuccess(cartBean);
                    }
                });

    }
}
