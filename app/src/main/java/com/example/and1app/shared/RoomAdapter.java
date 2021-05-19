package com.example.and1app.shared;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.and1app.R;
import com.example.and1app.editroom.EditRoomActivity;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.ViewHolder> {

    private ArrayList<Room> rooms;
    final private OnListItemClickListener listItem;
    private Activity activity;

    public RoomAdapter(Activity activity, ArrayList<Room> rooms, OnListItemClickListener listItem) {
        this.activity = activity;
        this.rooms = rooms;
        this.listItem = listItem;
    }

    public interface OnListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.room_list_item, parent, false);
        return new ViewHolder(view);
    }

    public void setData(ArrayList<Room> rooms)
    {
        this.rooms = rooms;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.title.setText(String.valueOf(rooms.get(position).getTitle()));
    holder.temperature.setText(String.valueOf(rooms.get(position).getRoomTemperature()));
    holder.button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent1 = new Intent(activity, EditRoomActivity.class);
            intent1.putExtra("room", rooms.get(position));
            activity.startActivity(intent1);
        }
    });

    }

    @Override
    public int getItemCount() {
        return rooms.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView title;
        TextView temperature;
        Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name);
            temperature = itemView.findViewById(R.id.temperature);
            button = itemView.findViewById(R.id.editButton);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            System.out.println("dasda");
            listItem.onListItemClick(getAdapterPosition());

        }

    }
}
