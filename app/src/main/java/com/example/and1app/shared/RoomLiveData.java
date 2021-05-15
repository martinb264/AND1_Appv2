package com.example.and1app.shared;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RoomLiveData extends LiveData<ArrayList<Room>> {
    ArrayList<Room> rooms = new ArrayList<>();
    private final ValueEventListener listener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            System.out.println("ondatachange");
           for (DataSnapshot ds : snapshot.getChildren()) {
                   Room room = ds.getValue(Room.class);
                   Log.d("TAG", room.getTitle());
               rooms.add(room);
           }
            setValue(rooms);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };
    DatabaseReference reference;

    public RoomLiveData(DatabaseReference ref)
    {
        reference = ref;

    }


    @Override
    protected void onActive() {
        super.onActive();
        reference.addValueEventListener(listener);
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        reference.removeEventListener(listener);
    }
}
