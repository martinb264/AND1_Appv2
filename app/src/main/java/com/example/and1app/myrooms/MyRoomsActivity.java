package com.example.and1app.myrooms;

import android.content.Intent;
import android.os.Bundle;
import com.example.and1app.R;
import com.example.and1app.createroom.CreateRoomActivity;
import com.example.and1app.editroom.EditRoomActivity;
import com.example.and1app.homepage.HomeViewModel;
import com.example.and1app.homepage.MainActivity;
import com.example.and1app.shared.Room;
import com.example.and1app.shared.RoomAdapter;

import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

public class MyRoomsActivity extends AppCompatActivity implements RoomAdapter.OnListItemClickListener {


    private RecyclerView roomList;
    private RoomAdapter roomAdapter;
    private MyRoomsViewModel myRoomsViewModel;
    private Button editButton;
    private ArrayList<Room> rooms = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_rooms);
        myRoomsViewModel = new ViewModelProvider(this).get(MyRoomsViewModel.class);
        System.out.println("init");
        myRoomsViewModel.init();
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        editButton = findViewById(R.id.editButton);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        roomList = findViewById(R.id.rv);
        roomList.setLayoutManager(new LinearLayoutManager(this));
        roomList.hasFixedSize();
        roomAdapter = new RoomAdapter(MyRoomsActivity.this,rooms,this);
        roomList.setAdapter(roomAdapter);
        myRoomsViewModel.getRooms().observe(this,room -> {
                roomAdapter.setData(room);
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

    public void onEdit(Room room)
    {
        Intent intent1 = new Intent(this, EditRoomActivity.class);
        intent1.putExtra("room", room);
        startActivity(intent1);
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
        System.out.println(clickedItemIndex);
        int roomNumber = clickedItemIndex + 1;
        Toast.makeText(this,"Room number: " + roomNumber,Toast.LENGTH_SHORT).show();
    }
}