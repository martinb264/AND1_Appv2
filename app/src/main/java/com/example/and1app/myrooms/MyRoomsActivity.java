package com.example.and1app.myrooms;

import android.content.Intent;
import android.os.Bundle;
import com.example.and1app.R;
import com.example.and1app.createroom.CreateRoomActivity;
import com.example.and1app.homepage.HomeViewModel;
import com.example.and1app.homepage.MainActivity;
import com.example.and1app.shared.Room;
import com.example.and1app.shared.RoomAdapter;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyRoomsActivity extends AppCompatActivity implements RoomAdapter.OnListItemClickListener {

    private TextView mTextView;
    private RecyclerView roomList;
    private RoomAdapter roomAdapter;
    private MyRoomsViewModel myRoomsViewModel;
    ArrayList<Room> rooms = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_rooms);
        myRoomsViewModel = new ViewModelProvider(this).get(MyRoomsViewModel.class);
        myRoomsViewModel.init();
        mTextView = (TextView) findViewById(R.id.text);
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        roomList = findViewById(R.id.rv);
        roomList.hasFixedSize();
        roomList.setLayoutManager(new LinearLayoutManager(this));
        myRoomsViewModel.getRooms().observe(this,room -> {
            for (int i=0; i<room.size(); i++) {
                if (room.get(i) != null) {
                        rooms.add(room.get(i));
                }
                roomAdapter = new RoomAdapter(rooms,this);
                LinearLayoutManager linearLayout = new LinearLayoutManager(getApplicationContext());
                roomList.setAdapter(roomAdapter);
                roomList.setLayoutManager(linearLayout);

            }
        });






    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;

    }

    public void onFabClick(View view)
    {
        Intent intent = new Intent(this, CreateRoomActivity.class);
        startActivity(intent);
    }

    public void fill(ArrayList<Room> list)
    {
        for(int i=0; i<list.size();i++)
        {
            if (list.get(i) != null) {
                rooms.add(list.get(i));
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.my_rooms:
                Intent intent = new Intent(MyRoomsActivity.this, MyRoomsActivity.class);
                startActivity(intent);
                return true;
            case R.id.Signout:
                myRoomsViewModel.signOut();
                return true;
            case R.id.Settings:

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        int roomNumber = clickedItemIndex + 1;
        Toast.makeText(this,"Room number: " + roomNumber,Toast.LENGTH_SHORT).show();
    }
}