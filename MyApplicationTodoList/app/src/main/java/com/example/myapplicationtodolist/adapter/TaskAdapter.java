package com.example.myapplicationtodolist.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationtodolist.R;

public class TaskAdapter extends RecyclerView.Adapter {

    private OnTaskListener onTaskListener;

    public TaskAdapter(OnTaskListener onTaskListener){
        this.onTaskListener = onTaskListener;
    }

    //ranger tout les composants à controler
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private OnTaskListener onTaskListener;

        public ViewHolder(@NonNull View itemView, OnTaskListener listener) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.onTaskListener = listener;
        }

        @Override
        public void onClick(View view) {
            onTaskListener.onTaskClick(getAdapterPosition(),view);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_vertical_tickets, parent, false);
        return new ViewHolder(itemView, this.onTaskListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }
    @Override
    public int getItemCount() {
        return 2;
    }

    public interface OnTaskListener{
        void onTaskClick(int position, View view);
    }

}
