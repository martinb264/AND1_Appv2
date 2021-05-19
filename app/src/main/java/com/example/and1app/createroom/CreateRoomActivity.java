package com.example.and1app.createroom;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.and1app.R;
import com.example.and1app.myrooms.MyRoomsViewModel;
import com.example.and1app.shared.GroundHeat;
import com.example.and1app.shared.Radiator;
import com.example.and1app.shared.Room;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.auth.api.Auth;
import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

public class CreateRoomActivity extends AppCompatActivity {

    private EditText title;
    private EditText radiatorID;
    private EditText groundHeatID;
    private EditText thermostatID;
    private Room room;
    private CreateRoomViewModel createRoomViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_room);
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        title = findViewById(R.id.createTitle);
        radiatorID = findViewById(R.id.createRadiatorID);
        groundHeatID = findViewById(R.id.groundHeatID);
        thermostatID = findViewById(R.id.thermostatID);

        createRoomViewModel = new ViewModelProvider(this).get(CreateRoomViewModel.class);
        createRoomViewModel.init();


    }
    public void checkRadiator(View view)
    {
        if (!radiatorID.getText().toString().equals(""))
        {
            Toast.makeText(this,"Connection established to radiator",Toast.LENGTH_SHORT).show();
        }
    }

    public void checkGroundHeat(View view)
    {
        if (!groundHeatID.getText().toString().equals(""))
        {
        Toast.makeText(this,"Connection established to groundheat",Toast.LENGTH_SHORT).show();
        }
    }

    public void checkThermostat(View view)
    {
        if (!thermostatID.getText().toString().equals(""))
        {
            Toast.makeText(this,"Connection established to thermostat",Toast.LENGTH_SHORT).show();
        }
    }


    public void createRoom(View view)
    {
        System.out.println(title.getText().toString());
        if (title.getText().toString().equals(""))
        {
            Toast.makeText(this,"Error: No Title",Toast.LENGTH_SHORT).show();
        } else if (radiatorID.getText().toString().equals("") && groundHeatID.getText().toString().equals("") && thermostatID.getText().toString().equals(""))
        {
            Toast.makeText(this,"Please insert an id for atleast one of the options",Toast.LENGTH_SHORT).show();
        } else if (groundHeatID.getText().toString().equals("") && !radiatorID.getText().toString().equals("") && thermostatID.getText().toString().equals(""))
        {
            Radiator radiator = new Radiator(radiatorID.getText().toString());
            room = new Room(title.getText().toString(),radiator);
            createRoomViewModel.createRoom(room);
        }
        else if (!groundHeatID.getText().toString().equals("") && radiatorID.getText().toString().equals("") && thermostatID.getText().toString().equals(""))
        {
            GroundHeat groundHeat = new GroundHeat(groundHeatID.getText().toString());
            room = new Room(title.getText().toString(),groundHeat);
            createRoomViewModel.createRoom(room);
        }
        else if (!groundHeatID.getText().toString().equals("") && !radiatorID.getText().toString().equals("") && thermostatID.getText().toString().equals(""))
        {
            Radiator radiator = new Radiator(radiatorID.getText().toString());
            GroundHeat groundHeat = new GroundHeat(groundHeatID.getText().toString());
            room = new Room(title.getText().toString(),radiator,groundHeat);
            createRoomViewModel.createRoom(room);
        }
        else if (!groundHeatID.getText().toString().equals("") && !radiatorID.getText().toString().equals("") && !thermostatID.getText().toString().equals(""))
        {
            Radiator radiator = new Radiator(radiatorID.getText().toString());
            GroundHeat groundHeat = new GroundHeat(groundHeatID.getText().toString());
            room = new Room(title.getText().toString(),thermostatID.getText().toString(),radiator,groundHeat);
            createRoomViewModel.createRoom(room);
        }
        else if (groundHeatID.getText().toString().equals("") && !radiatorID.getText().toString().equals("") && !thermostatID.getText().toString().equals(""))
        {
            Radiator radiator = new Radiator(radiatorID.getText().toString());
            room = new Room(title.getText().toString(),thermostatID.getText().toString(),radiator);
            createRoomViewModel.createRoom(room);
        }
        else if (!groundHeatID.getText().toString().equals("") && radiatorID.getText().toString().equals("") && !thermostatID.getText().toString().equals(""))
        {
            GroundHeat groundHeat = new GroundHeat(groundHeatID.getText().toString());
            room = new Room(title.getText().toString(),thermostatID.getText().toString(),groundHeat);
            createRoomViewModel.createRoom(room);
        }
        else if (groundHeatID.getText().toString().equals("") && radiatorID.getText().toString().equals("") && !thermostatID.getText().toString().equals(""))
        {
            room = new Room(title.getText().toString(),thermostatID.getText().toString());
            createRoomViewModel.createRoom(room);
        }
    }
}