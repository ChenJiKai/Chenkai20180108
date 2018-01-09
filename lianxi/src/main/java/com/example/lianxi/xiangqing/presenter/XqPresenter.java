package com.example.lianxi.xiangqing.presenter;

import com.example.lianxi.bean.GoodXiangBean;
import com.example.lianxi.net.OnNetListener;
import com.example.lianxi.xiangqing.model.IXqModel;
import com.example.lianxi.xiangqing.model.XqModel;
import com.example.lianxi.xiangqing.view.XqActivity;

/**
 * Created by asus on 2018/1/5.
 */

public class XqPresenter {
    private XqActivity xqActivity;
    private IXqModel iXqModel;

    public XqPresenter(XqActivity xqActivity) {
        this.xqActivity = xqActivity;
        this.iXqModel=new XqModel();
    }
    public void getData(String pid){
        iXqModel.getShow(new OnNetListener<GoodXiangBean>() {
            @Override
            public void onSuccess(GoodXiangBean goodXiangBean) {

                xqActivity.showNews(goodXiangBean);
            }

            @Override
            public void onFailure(Exception e) {

            }
        },pid);
    }
}
