package com.example.and1app.homepage;

public class HomeDao {

    private static HomeDao instance;


    private HomeDao()
    {

    }
    public static HomeDao getInstance() {
        if (instance == null)
        {
            instance = new HomeDao();
        }
        return instance;
    }
}
