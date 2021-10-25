package com.example.myapplicationtodolist.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationtodolist.R;

public class TaskAdapterCalendar extends RecyclerView.Adapter<TaskAdapterCalendar.ViewHolder>{


    Activity activity;
    TaskAdapter.OnTaskListener onTaskListener;
    public TaskAdapterCalendar(Activity activity, TaskAdapter.OnTaskListener onTaskListener){

        this.activity = activity;
        this.onTaskListener = onTaskListener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        RecyclerView itemPlanningDay;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemPlanningDay = itemView.findViewById(R.id.recycle_view_calendar_item);
        }
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;

        itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_calendar, parent, false);

        //collect the recycleView in the item

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TaskAdapter taskAdapter = new TaskAdapter(onTaskListener);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        holder.itemPlanningDay.setLayoutManager(linearLayoutManager);
        holder.itemPlanningDay.setAdapter(taskAdapter);
    }



    @Override
    public int getItemCount() {
        return 5;
    }
}
