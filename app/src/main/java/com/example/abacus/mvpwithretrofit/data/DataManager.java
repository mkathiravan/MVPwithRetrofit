package com.example.abacus.mvpwithretrofit.data;

import com.example.abacus.mvpwithretrofit.data.network.service.ActorService;

public class DataManager {

    private static DataManager sInstance;

    private DataManager()
    {

    }

    public static synchronized DataManager getsInstance ()
    {
        if(sInstance == null)
        {
            sInstance = new DataManager();
        }
        return sInstance;
    }

    public ActorService getActorService()
    {
        return new ActorService();
    }


}
