package com.example.and1app.homepage;

import android.app.ApplicationErrorReport;

public class HomeRepository {

    private HomeDao homeDao;
    private static HomeRepository instance;

    private HomeRepository()
    {
        homeDao = HomeDao.getInstance();
    }

    public static HomeRepository getInstance() {
        if (instance == null)
        {
            instance = new HomeRepository();
        }
        return instance;
    }
}
