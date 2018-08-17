package com.example.abacus.mvpwithretrofit.ui.activity.MainActivity.presenter;

import com.example.abacus.mvpwithretrofit.data.network.model.ActorsResponse;
import com.example.abacus.mvpwithretrofit.data.network.service.ActorService;
import com.example.abacus.mvpwithretrofit.ui.activity.MainActivity.view.MainActivityView;
import com.example.abacus.mvpwithretrofit.ui.activity.base.BasePresenter;

import java.lang.ref.WeakReference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityPresenter extends BasePresenter<MainActivityView>{

    private final ActorService mActService;

    public MainActivityPresenter(MainActivityView view, ActorService mActorService) {
        super(view);
        mActService = mActorService;
    }

    public void getAllActors()
    {
        Call<ActorsResponse> actorscall = mActService.getmMovieApi().getAllActors();
        actorscall.enqueue(new ActorCallListener(mView));
    }


    private static class ActorCallListener implements Callback<ActorsResponse>
    {
        private WeakReference<MainActivityView> mView;

        private ActorCallListener(MainActivityView View) {
            mView = new WeakReference<>(View);
        }

        @Override
        public void onResponse(Call<ActorsResponse> call, Response<ActorsResponse> response) {

            if(mView.get() != null)
            {
                mView.get().onGetActors(response.body());
            }
        }

        @Override
        public void onFailure(Call<ActorsResponse> call, Throwable t) {

            t.fillInStackTrace();

        }
    }
}
