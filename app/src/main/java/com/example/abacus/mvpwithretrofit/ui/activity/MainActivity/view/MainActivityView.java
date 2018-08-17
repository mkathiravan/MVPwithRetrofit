package com.example.abacus.mvpwithretrofit.ui.activity.MainActivity.view;

import com.example.abacus.mvpwithretrofit.data.network.model.ActorsResponse;
import com.example.abacus.mvpwithretrofit.ui.activity.base.BaseView;

public interface MainActivityView extends BaseView{

    void onGetActors(ActorsResponse actorsResponse);
}
