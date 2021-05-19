package com.example.and1app.editroom;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import com.example.and1app.R;
import com.example.and1app.myrooms.MyRoomsActivity;
import com.example.and1app.myrooms.MyRoomsViewModel;
import com.example.and1app.shared.Room;

public class EditRoomActivity extends AppCompatActivity {

    private EditText title;
    private EditText radiatorTemperature;
    private EditText groundHeatTemperature;
    private Switch radiatorSwitch;
    private Switch groundHeatSwitch;
    EditRoomViewModel roomViewModel;

    private Room room;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_room);
        roomViewModel = new ViewModelProvider(this).get(EditRoomViewModel.class);
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        room = (Room) getIntent().getSerializableExtra("room");
        roomViewModel.init(room.getUniqueID());
        title = findViewById(R.id.edit_title);
        radiatorTemperature = findViewById(R.id.edit_radiator);
        groundHeatTemperature = findViewById(R.id.edit_groundheat);
        radiatorSwitch = findViewById(R.id.switch1);
        groundHeatSwitch = findViewById(R.id.switch2);
        title.setText(room.getTitle());
        radiatorTemperature.setInputType(InputType.TYPE_CLASS_NUMBER);
        groundHeatTemperature.setInputType(InputType.TYPE_CLASS_NUMBER);
        if (room.getRadiator() != null)
        {
            radiatorTemperature.setText(String.valueOf(room.getRadiator().getTemperature()));
            radiatorSwitch.setChecked(room.getRadiator().isTemperatureOn());
        }
        if (room.getGroundHeat() != null)
        {
            groundHeatTemperature.setText(String.valueOf(room.getGroundHeat().getTemperature()));
            groundHeatSwitch.setChecked(room.getGroundHeat().getTemperatureOn());

        }


    }

    public void onEdit(View view)
    {
        System.out.println(radiatorSwitch.isChecked());
        room.setTitle(title.getText().toString());
        if (room.getRadiator() != null) {
            room.getRadiator().setTemperature(Integer.parseInt(radiatorTemperature.getText().toString()));
            room.getRadiator().setTemperatureOn(radiatorSwitch.isChecked());
        }
        if (room.getGroundHeat() != null) {
            room.getGroundHeat().setTemperature(Integer.parseInt(groundHeatTemperature.getText().toString()));
            room.getGroundHeat().setTemperatureOn(groundHeatSwitch.isChecked());
        }

        roomViewModel.onEdit(room);
        Intent intent = new Intent(EditRoomActivity.this, MyRoomsActivity.class);
        startActivity(intent);
    }


    public void onRemove(View view)
    {
        roomViewModel.onRemove();
        Intent intent = new Intent(EditRoomActivity.this, MyRoomsActivity.class);
        startActivity(intent);
    }
}