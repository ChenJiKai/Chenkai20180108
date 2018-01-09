package com.example.lianxi.net;


import com.example.lianxi.bean.AddCarBean;
import com.example.lianxi.bean.BaseBean;
import com.example.lianxi.bean.CartBean;
import com.example.lianxi.bean.GoodXiangBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by wsq on 2017/12/12.
 */

public interface ServerApi {
    @GET(Api.BANNER)
    Observable<BaseBean> shou();
    @GET(Api.PRODUCTDETAIL)
    Observable<GoodXiangBean> detail(@Query("pid") String pid);
    @GET(Api.CART)
    Observable<CartBean> cart(@Query("uid") String uid, @Query("token") String token);
    @GET(Api.ADDCART)
    Observable<AddCarBean> addCart(@Query("uid") String uid, @Query("pid") int pid);
    //删除购物车
    @GET(Api.DELETECAR_PATH_URL)
    Observable<BaseBean> deleteGoodCar(@Query("uid") String uid, @Query("pid") String pid);
}
