package com.example.and1app.myrooms;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.and1app.shared.RoomLiveData;
import com.example.and1app.signin.UserRepository;
import com.google.firebase.auth.FirebaseUser;

public class MyRoomsViewModel extends AndroidViewModel {

    private MyRoomsRepository myRoomsRepository;
    private UserRepository userRepository;

    public MyRoomsViewModel(@NonNull Application application)
    {
        super(application);
        myRoomsRepository = MyRoomsRepository.getInstance();
        userRepository = UserRepository.getInstance(application);
    }

    public RoomLiveData getRooms()
    {
        return myRoomsRepository.getRooms();
    }

    public void init()
    {
        String userID = userRepository.getCurrentUser().getValue().getUid();
        if (userID != null) {
            myRoomsRepository.init(userID);
        }
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
