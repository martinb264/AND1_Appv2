package com.example.and1app.editroom;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.and1app.signin.UserRepository;

public class EditRoomViewModel extends AndroidViewModel {
    private EditRoomRepositoy editRoomRepositoy;
    private UserRepository userRepository;

    public EditRoomViewModel(@NonNull Application application) {
        super(application);
        editRoomRepositoy = EditRoomRepositoy.getInstance();
        userRepository = UserRepository.getInstance(application);
    }
}
