package com.example.and1app.editroom;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.and1app.shared.Room;
import com.example.and1app.signin.UserRepository;
import com.google.firebase.auth.FirebaseUser;

public class EditRoomViewModel extends AndroidViewModel {
    private EditRoomRepositoy editRoomRepositoy;
    private UserRepository userRepository;

    public EditRoomViewModel(@NonNull Application application) {
        super(application);
        editRoomRepositoy = EditRoomRepositoy.getInstance();
        userRepository = UserRepository.getInstance(application);
    }

    public LiveData<FirebaseUser> getCurrentUser()
    {
        return userRepository.getCurrentUser();
    }

    public void init(String userID)
    {
        editRoomRepositoy.init(getCurrentUser().getValue().getUid(),userID);
    }

    public void onEdit(Room room)
    {
        editRoomRepositoy.onEdit(room);
    }

    public void onRemove()
    {
        editRoomRepositoy.onRemove();
    }
}
