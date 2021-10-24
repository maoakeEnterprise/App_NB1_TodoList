package com.example.myapplicationtodolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplicationtodolist.fragments.CalendarFragment;
import com.example.myapplicationtodolist.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity{

    private BottomSheetMenu bottomSheetMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initBottomSheetMenu();
        activeButtonListenerBottomSheet();
        
        loadFragment(new HomeFragment());
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
            startActivityAddTask(view);
            //overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
        });

        bottomSheetMenu.buttonGraphTracking.setOnClickListener(view -> {

        });
        bottomSheetMenu.buttonMainActivity.setOnClickListener(view -> {
            loadFragment(new HomeFragment());
            bottomSheetMenu.setCollapsedBottomSheetMenu();
        });
        bottomSheetMenu.buttonNextTask.setOnClickListener(view -> {
            loadFragment(new CalendarFragment(this));
            bottomSheetMenu.setCollapsedBottomSheetMenu();
        });
        bottomSheetMenu.buttonProject.setOnClickListener(view -> {

        });
        bottomSheetMenu.buttonTickets.setOnClickListener(view -> {

        });
        bottomSheetMenu.buttonSettings.setOnClickListener(view -> {

        });

    }

    public void startActivityAddTask(View v){
        Intent intent = new Intent(v.getContext(),AddTaskActivity.class);
        v.getContext().startActivity(intent);
    }


}