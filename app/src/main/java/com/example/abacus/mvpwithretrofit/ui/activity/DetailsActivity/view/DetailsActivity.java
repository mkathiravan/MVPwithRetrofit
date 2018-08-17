package com.example.abacus.mvpwithretrofit.ui.activity.DetailsActivity.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.abacus.mvpwithretrofit.R;
import com.example.abacus.mvpwithretrofit.ui.activity.DetailsActivity.presenter.DetailsActivityPresenter;
import com.example.abacus.mvpwithretrofit.ui.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends BaseActivity<DetailsActivityPresenter> implements DetailsActivityView
{

    @BindView(R.id.image)
    AppCompatImageView mImage;
    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.desc) TextView mDesc;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        mPresenter.getIntentExtras(getIntent());
    }

    @NonNull
    @Override
    protected DetailsActivityPresenter createPresenter() {
        return new DetailsActivityPresenter(this);
    }


    @Override
    public void updateActivityView(String imageUrl, String title, String description) {

        mTitle.setText(title);
        mDesc.setText(description);
        Glide.with(getApplicationContext()).load(imageUrl).into(mImage);

    }
}
