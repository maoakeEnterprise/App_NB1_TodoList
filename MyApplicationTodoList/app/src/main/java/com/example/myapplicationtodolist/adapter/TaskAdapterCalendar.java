package com.example.myapplicationtodolist.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationtodolist.R;

public class TaskAdapterCalendar extends RecyclerView.Adapter{

    class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;

        itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_calendar, parent, false);

        //collect the recycleView in the item
        RecyclerView verticalRecyclerView = itemView.findViewById(R.id.recycle_view_calendar_item);
        verticalRecyclerView.setAdapter(new TaskAdapter());

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
