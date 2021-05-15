package com.example.and1app.signin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.and1app.R;
import com.example.and1app.homepage.MainActivity;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.util.Arrays;
import java.util.List;

public class SignInActivity extends AppCompatActivity {
    private static final int RC_SIGN_IN = 21;
    private SignInViewModel viewModel;
    private FirebaseAuth auth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference myref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(SignInViewModel.class);
        auth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance("https://sep-4-77004-default-rtdb.europe-west1.firebasedatabase.app/");
        myref = firebaseDatabase.getReference("Users");
        check();
        setContentView(R.layout.activity_sign_in);
    }

    private void check()
    {
        viewModel.getCurrentUser().observe(this,user -> {
            if (user != null)
            {
                goToMainActivity();
            }
        });
    }
    public void  goToMainActivity()
    {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
    public void signIn(View view)
    {
        List<AuthUI.IdpConfig> idpConfigs = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build());

        Intent signInIntent = AuthUI.getInstance().createSignInIntentBuilder()
                .setAvailableProviders(idpConfigs).setLogo(R.drawable.fui_ic_twitter_bird_white_24dp).build();

        startActivityForResult(signInIntent,RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN){
            handleSignIn(RC_SIGN_IN);
        }
    }

    private void handleSignIn(int code)
    {
        if (code == RC_SIGN_IN)
        {
            myref.push().setValue(auth.getUid());
            goToMainActivity();
        }
        else
        {
            Toast.makeText(this,"Sign In Failed",Toast.LENGTH_SHORT).show();
        }
    }
}
