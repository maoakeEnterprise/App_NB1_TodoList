package com.example.myapplicationtodolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplicationtodolist.fragments.CalendarFragment;
import com.example.myapplicationtodolist.fragments.GraphicsFragment;
import com.example.myapplicationtodolist.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity{

    private BottomSheetMenu bottomSheetMenu;
    private FrameLayout test;
    private HomeFragment homeFragment;
    private BottomSheetTask bottomSheetTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment = new HomeFragment();

        initBottomSheetMenu();
        activeButtonListenerBottomSheet();
        activeButtonHomeFragment();

        loadFragment(homeFragment);
    }

    private void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void initBottomSheetMenu(){
        bottomSheetMenu = new BottomSheetMenu(findViewById(R.id.bottom_sheet_menu_Container));
        bottomSheetMenu.showBottomSheet();
        bottomSheetMenu.activateButtonActivity();
    }

    private void activeButtonListenerBottomSheet(){
        bottomSheetMenu.buttonAddBottomSheet.setOnClickListener(view -> {
            startActivityAddTask(view,new Intent(view.getContext(),AddTaskActivity.class));
            //overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
        });

        bottomSheetMenu.buttonGraphTracking.setOnClickListener(view -> {
            loadFragment(new GraphicsFragment());
            bottomSheetMenu.setCollapsedBottomSheetMenu();
        });
        bottomSheetMenu.buttonMainActivity.setOnClickListener(view -> {
            loadFragment(new HomeFragment());
            bottomSheetMenu.setCollapsedBottomSheetMenu();
        });
        bottomSheetMenu.buttonNextTask.setOnClickListener(view -> {
            loadFragment(new CalendarFragment(this));
            bottomSheetMenu.setCollapsedBottomSheetMenu();
        });
        bottomSheetMenu.buttonAddProject.setOnClickListener(view -> {
            startActivityAddTask(view,new Intent(view.getContext(),CreateProjetcActivity.class));
        });
        bottomSheetMenu.buttonTickets.setOnClickListener(view -> {
            startActivityAddTask(view,new Intent(view.getContext(),AddTicketsActivity.class));
        });
        bottomSheetMenu.buttonSettings.setOnClickListener(view -> {

        });

    }

    public void activeButtonHomeFragment(){
        homeFragment.itemTickets.setOnClickListener(view -> {

        });
    }

    public void startActivityAddTask(View v, Intent intent){
        v.getContext().startActivity(intent);
    }


}