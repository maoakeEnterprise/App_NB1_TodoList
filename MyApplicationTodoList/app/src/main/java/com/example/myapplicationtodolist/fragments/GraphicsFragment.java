package com.example.myapplicationtodolist.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationtodolist.Etiquettes;
import com.example.myapplicationtodolist.R;
import com.example.myapplicationtodolist.adapter.TaskAdapter;

public class GraphicsFragment extends Fragment {

    TaskAdapter.OnTaskListener onTaskListener;
    private Etiquettes tickets;

    public GraphicsFragment(TaskAdapter.OnTaskListener onTaskListener, Etiquettes tickets){
        this.onTaskListener = onTaskListener;
        this.tickets = tickets;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_graph_tracking, container, false);

        //recuperer le recycle view

        RecyclerView verticalRecycleView = view.findViewById(R.id.vertical_recycle_view);
        verticalRecycleView.setAdapter(new TaskAdapter(onTaskListener, this.tickets));

        return view;
    }
}
