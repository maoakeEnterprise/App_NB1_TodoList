package com.example.myapplicationtodolist.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationtodolist.R;
import com.example.myapplicationtodolist.adapter.TaskAdapter;
import com.example.myapplicationtodolist.adapter.TaskAdapterCalendar;

public class CalendarFragment extends Fragment {

    Activity activity;
    TaskAdapter.OnTaskListener onTaskListener;

    public CalendarFragment(Activity activity, TaskAdapter.OnTaskListener onTaskListener){
        this.activity = activity;
        this.onTaskListener = onTaskListener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);

        //recuperer le recycle view
        RecyclerView verticalRecycleView = view.findViewById(R.id.recycle_view_calendar_fragment);
        verticalRecycleView.setAdapter(new TaskAdapterCalendar(activity,onTaskListener));

        return view;
    }
}
