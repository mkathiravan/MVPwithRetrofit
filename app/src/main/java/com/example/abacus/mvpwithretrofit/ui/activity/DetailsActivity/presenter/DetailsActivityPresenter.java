package com.example.abacus.mvpwithretrofit.ui.activity.DetailsActivity.presenter;

import android.content.Intent;

import com.example.abacus.mvpwithretrofit.data.network.model.Actors;
import com.example.abacus.mvpwithretrofit.ui.activity.DetailsActivity.view.DetailsActivityView;
import com.example.abacus.mvpwithretrofit.ui.activity.base.BasePresenter;

public class DetailsActivityPresenter extends BasePresenter<DetailsActivityView> {


    public DetailsActivityPresenter(DetailsActivityView view) {
        super(view);
    }

    public void getIntentExtras(Intent intent)
    {
        Actors actors = intent.getExtras().getParcelable("actor");
        mView.updateActivityView(actors.getImage(),actors.getName(),actors.getDescription());
    }
}
