package com.example.and1app.createroom;

import com.example.and1app.shared.Room;

public class CreateRoomRepository {
    private CreateRoomDao createRoomDao;
    private static CreateRoomRepository instance;

    public CreateRoomRepository() {
        createRoomDao = CreateRoomDao.getInstance();
    }

    public static CreateRoomRepository getInstance() {
        if (instance == null)
        {
            instance = new CreateRoomRepository();
        }
        return instance;
    }
    public void init(String userID)
    {
        createRoomDao.init(userID);
    }
    public void createRoom(Room room)
    {
        createRoomDao.createRoom(room);
    }
}
