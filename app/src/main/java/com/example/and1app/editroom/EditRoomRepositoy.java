package com.example.and1app.editroom;

import com.example.and1app.createroom.CreateRoomRepository;

public class EditRoomRepositoy {
    private static EditRoomRepositoy instance;
    private EditRoomDao editRoomDao;

    public EditRoomRepositoy()
    {
        editRoomDao = EditRoomDao.getInstance();
    }

    public static EditRoomRepositoy getInstance() {
        if (instance == null)
        {
            instance = new EditRoomRepositoy();
        }
        return instance;
    }

}
