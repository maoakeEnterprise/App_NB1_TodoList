package com.example.myapplicationtodolist.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationtodolist.Etiquette;
import com.example.myapplicationtodolist.Etiquettes;
import com.example.myapplicationtodolist.R;
import com.example.myapplicationtodolist.adapter.TaskAdapter;

public class HomeFragment extends Fragment{

    private TaskAdapter.OnTaskListener onTaskListener;
    private Etiquettes tickets;

    public HomeFragment(TaskAdapter.OnTaskListener onTaskListener, Etiquettes tickets){
        this.onTaskListener = onTaskListener;
        this.tickets = tickets;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        TaskAdapter taskAdapter = new TaskAdapter(this.onTaskListener, this.tickets);
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //recuperer le recycle view

        RecyclerView verticalRecycleView = view.findViewById(R.id.vertical_recycle_view);
        verticalRecycleView.setAdapter(taskAdapter);

        return view;
    }
}
