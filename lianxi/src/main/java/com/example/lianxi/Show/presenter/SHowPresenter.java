package com.example.lianxi.Show.presenter;

import com.example.lianxi.Show.model.IShowModel;
import com.example.lianxi.Show.model.ShowModel;
import com.example.lianxi.Show.view.IMainActivity;
import com.example.lianxi.bean.BaseBean;
import com.example.lianxi.net.OnNetListener;

/**
 * Created by asus on 2018/1/8.
 */

public class SHowPresenter {
    private IMainActivity iMainActivity;
    private IShowModel iShowModel;

    public SHowPresenter(IMainActivity iMainActivity) {
        this.iMainActivity = iMainActivity;
        this.iShowModel=new ShowModel();
    }
    public void getData(){
        iShowModel.getList(new OnNetListener<BaseBean>() {
            @Override
            public void onSuccess(BaseBean baseBean) {
                iMainActivity.getShow(baseBean);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
