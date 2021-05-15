package com.example.and1app.homepage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.and1app.R;
import com.example.and1app.myrooms.MyRoomsActivity;
import com.example.and1app.signin.SignInActivity;
import com.example.and1app.homepage.ui.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private HomeViewModel homeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        checkifSignedIn();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;

    }

    private void checkifSignedIn()
    {
        homeViewModel.getCurrentUser().observe(this, user -> {
            if (user != null) {
                Toast.makeText(this,"Welcome " + user.getDisplayName(),Toast.LENGTH_SHORT).show();
            } else
                startLoginActivity();
        });
    }

    private void startLoginActivity()
    {
        startActivity(new Intent(this, SignInActivity.class));
        finish();
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.my_rooms:
                Intent intent = new Intent(MainActivity.this, MyRoomsActivity.class);
                startActivity(intent);
            return true;
            case R.id.Signout:
                homeViewModel.signOut();
            return true;
            case R.id.Settings:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}