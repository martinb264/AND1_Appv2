package com.example.and1app.editroom;

import com.example.and1app.createroom.CreateRoomDao;
import com.example.and1app.shared.Room;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditRoomDao {
    private static EditRoomDao instance;
    FirebaseDatabase database = FirebaseDatabase.getInstance("https://sep-4-77004-default-rtdb.europe-west1.firebasedatabase.app/");
    DatabaseReference ref;


    public EditRoomDao()
    {

    }

    public void init(String userID,String roomID)
    {
        ref = database.getReference("Users").child(userID).child("Rooms").child(roomID);

    }

    public void onEdit(Room room)
    {
        ref.setValue(room);
    }

    public void onRemove()
    {
        ref.removeValue();
    }

    public static EditRoomDao getInstance() {
        if (instance == null)
        {
            instance = new EditRoomDao();
        }
        return instance;
    }
}
