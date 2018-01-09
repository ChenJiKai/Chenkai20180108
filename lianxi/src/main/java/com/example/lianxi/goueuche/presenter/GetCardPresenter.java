package com.example.lianxi.goueuche.presenter;

import com.example.lianxi.bean.CartBean;
import com.example.lianxi.goueuche.model.GetCardModel;
import com.example.lianxi.goueuche.model.IGetCardModel;
import com.example.lianxi.goueuche.view.ICartFragment;
import com.example.lianxi.net.OnNetListener;

/**
 * Created by Administrator on 2017/12/19.
 */

public class GetCardPresenter {
    private ICartFragment iCartFragment;
    private IGetCardModel iGetCardModel;

    public GetCardPresenter(ICartFragment iCartFragment) {
        this.iCartFragment = iCartFragment;
        iGetCardModel = new GetCardModel();
    }

    public void getCarts(String uid,String token) {

        iGetCardModel.getCard(uid, token, new OnNetListener<CartBean>() {
            @Override
            public void onSuccess(CartBean cartBean) {
                iCartFragment.onShow(cartBean);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
