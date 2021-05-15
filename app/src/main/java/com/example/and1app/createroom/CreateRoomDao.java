package com.example.and1app.createroom;

import com.example.and1app.homepage.HomeDao;
import com.example.and1app.shared.Room;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateRoomDao {
   private static CreateRoomDao instance;
   FirebaseDatabase database = FirebaseDatabase.getInstance("https://sep-4-77004-default-rtdb.europe-west1.firebasedatabase.app/");
   DatabaseReference myRef;


    public CreateRoomDao() {

    }

    public void init(String userID)
    {
        myRef = database.getReference().child("Users").child(userID).child("Rooms");
    }
    public static CreateRoomDao getInstance() {
        if (instance == null)
        {
            instance = new CreateRoomDao();
        }
        return instance;
    }

    public void createRoom(Room room,String userID)
    {
        myRef.push().setValue(room);
    }
}
