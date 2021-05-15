package com.example.and1app.myrooms;

import com.example.and1app.shared.RoomLiveData;

public class MyRoomsRepository {

    private final MyRoomsDao myRoomsDao;


    private static MyRoomsRepository instance;

    private MyRoomsRepository()
    {
        myRoomsDao = MyRoomsDao.getInstance();
    }

    public static MyRoomsRepository getInstance() {
        if (instance == null)
        {
            instance = new MyRoomsRepository();
        }
        return instance;
    }

    public RoomLiveData getRooms()
    {
        return myRoomsDao.getAllRooms();
    }
    public void init(String userID) {
        myRoomsDao.init(userID);
    }


}
