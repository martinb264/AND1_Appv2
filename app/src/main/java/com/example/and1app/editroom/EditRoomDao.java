package com.example.and1app.editroom;

import com.example.and1app.createroom.CreateRoomDao;
import com.google.firebase.database.FirebaseDatabase;

public class EditRoomDao {
    private static EditRoomDao instance;
    FirebaseDatabase database = FirebaseDatabase.getInstance("https://sep-4-77004-default-rtdb.europe-west1.firebasedatabase.app/");


    public EditRoomDao()
    {

    }

    public static EditRoomDao getInstance() {
        if (instance == null)
        {
            instance = new EditRoomDao();
        }
        return instance;
    }
}
