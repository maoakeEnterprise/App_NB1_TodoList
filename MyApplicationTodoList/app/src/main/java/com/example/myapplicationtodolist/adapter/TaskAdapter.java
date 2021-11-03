package com.example.myapplicationtodolist.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationtodolist.Etiquettes;
import com.example.myapplicationtodolist.R;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private OnTaskListener onTaskListener;
    private Etiquettes tickets;

    public TaskAdapter(OnTaskListener onTaskListener, Etiquettes tickets){

        this.onTaskListener = onTaskListener;
        this.tickets = tickets;
    }


    //ranger tout les composants à controler


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_vertical_tickets, parent, false);
        return new ViewHolder(itemView, this.onTaskListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameTickets.setText(this.tickets.getListeTickets().get(position).getNom());
        holder.describeTickets.setText(this.tickets.getListeTickets().get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return tickets.getListeTickets().size();
    }

    public interface OnTaskListener{
        void onTaskClick(int position, View view);
    }
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private OnTaskListener onTaskListener;
        TextView nameTickets;
        TextView describeTickets;


        public ViewHolder(@NonNull View itemView, OnTaskListener listener) {
            super(itemView);
            itemView.setOnClickListener(this);

            this.onTaskListener = listener;
            nameTickets = itemView.findViewById(R.id.textViewNameItem);
            describeTickets = itemView.findViewById(R.id.textViewDescriptionItem);
        }

        @Override
        public void onClick(View view) {
            onTaskListener.onTaskClick(getAdapterPosition(),view);
        }
    }


}
