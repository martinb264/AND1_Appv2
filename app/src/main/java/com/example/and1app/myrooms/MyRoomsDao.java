package com.example.and1app.myrooms;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

import com.example.and1app.shared.Room;
import com.example.and1app.shared.RoomLiveData;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MyRoomsDao {
  private static MyRoomsDao instance;
   private FirebaseDatabase database = FirebaseDatabase.getInstance("https://sep-4-77004-default-rtdb.europe-west1.firebasedatabase.app/");
    private DatabaseReference myRef;
    private RoomLiveData roomLiveData;




  private MyRoomsDao()
  {

  }

  public void init(String userID)
  {
      myRef = database.getReference("Users").child(userID).child("Rooms");
      roomLiveData = new RoomLiveData(myRef);
  }

    public static MyRoomsDao getInstance() {
        if (instance == null)
        {
            instance = new MyRoomsDao();
        }
        return instance;
    }

    public RoomLiveData getAllRooms() {
        return roomLiveData;
    }

    public void saveRoom(Room room)
    {
        myRef.setValue(room);
    }


    public void deleteRoom(Room room)
    {

    }
}
