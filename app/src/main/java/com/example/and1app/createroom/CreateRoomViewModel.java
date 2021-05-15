package com.example.and1app.createroom;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.and1app.shared.Room;
import com.example.and1app.signin.UserRepository;
import com.google.firebase.auth.FirebaseUser;

public class CreateRoomViewModel extends AndroidViewModel {
    CreateRoomRepository createRoomRepository;
    UserRepository userRepository;

    public CreateRoomViewModel(@NonNull Application application) {
        super(application);
        createRoomRepository = CreateRoomRepository.getInstance();
        userRepository = UserRepository.getInstance(application);
    }

    public void  createRoom(Room room)
    {
        createRoomRepository.createRoom(room,getCurrentUser().toString());
    }

    public void init()
    {
        String userID = userRepository.getCurrentUser().getValue().getUid();
        createRoomRepository.init(userID);
    }


    public void signOut()
    {
        userRepository.signOut();
    }
    public LiveData<FirebaseUser> getCurrentUser()
    {
        return userRepository.getCurrentUser();
    }
}
