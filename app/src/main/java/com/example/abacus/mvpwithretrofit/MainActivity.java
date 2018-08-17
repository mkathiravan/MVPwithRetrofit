package com.example.abacus.mvpwithretrofit;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.abacus.mvpwithretrofit.data.network.model.Actors;
import com.example.abacus.mvpwithretrofit.data.network.model.ActorsResponse;
import com.example.abacus.mvpwithretrofit.ui.activity.DetailsActivity.view.DetailsActivity;
import com.example.abacus.mvpwithretrofit.ui.activity.MainActivity.presenter.ActorsAdapter;
import com.example.abacus.mvpwithretrofit.ui.activity.MainActivity.presenter.MainActivityPresenter;
import com.example.abacus.mvpwithretrofit.ui.activity.MainActivity.view.MainActivityView;
import com.example.abacus.mvpwithretrofit.ui.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainActivityPresenter> implements MainActivityView,ActorsAdapter.OnMovieAdapter{

    ActorsAdapter mActorsAdapter;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mActorsAdapter = new ActorsAdapter(this);
        mRecyclerView.setAdapter(mActorsAdapter);
        mPresenter.getAllActors();
    }

    @NonNull
    @Override
    protected MainActivityPresenter createPresenter() {
        return new MainActivityPresenter(this,mDataManager.getActorService());
    }

    @Override
    public void onMovieClicked(Actors actors) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("actor", actors);
        startActivity(intent);

    }

    @Override
    public void onGetActors(ActorsResponse actorsResponse) {

        mActorsAdapter.setItems(actorsResponse.getActors());
    }
}
