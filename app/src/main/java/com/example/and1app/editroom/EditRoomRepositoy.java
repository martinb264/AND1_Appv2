package com.example.and1app.editroom;

import com.example.and1app.createroom.CreateRoomRepository;
import com.example.and1app.shared.Room;

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

    public void onEdit(Room room)
    {
        editRoomDao.onEdit(room);
    }

    public void onRemove()
    {
        editRoomDao.onRemove();
    }

    public void init(String userID,String roomID)
    {
        editRoomDao.init(userID,roomID);
    }

}
