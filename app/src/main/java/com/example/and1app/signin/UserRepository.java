package com.example.and1app.signin;

import android.app.Application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import com.example.and1app.shared.User;
import com.example.and1app.shared.UserLiveData;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseUser;

public class UserRepository {
    private final UserLiveData current;
    private final Application application;
    private static UserRepository instance;

    private UserRepository(Application application)
    {
        this.application =application;
        current = new UserLiveData();
    }

    public static synchronized UserRepository getInstance(Application application)
    {
        if (instance == null)
        {
            instance = new UserRepository(application);
        }
        return instance;
    }

    public LiveData<FirebaseUser> getCurrentUser()
    {
        return current;
    }

    public void signOut()
    {
        AuthUI.getInstance().signOut(application.getApplicationContext());
    }
}

