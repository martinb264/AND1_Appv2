package com.example.and1app.homepage;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.and1app.signin.UserRepository;
import com.google.firebase.auth.FirebaseUser;

public class HomeViewModel extends AndroidViewModel {
    private HomeRepository repository;
    private UserRepository userRepository;

    public HomeViewModel(@NonNull Application application)
    {
        super(application);
        repository = HomeRepository.getInstance();
        userRepository = UserRepository.getInstance(application);
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
