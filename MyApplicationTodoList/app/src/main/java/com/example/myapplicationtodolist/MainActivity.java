package com.example.myapplicationtodolist;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplicationtodolist.adapter.TaskAdapter;
import com.example.myapplicationtodolist.fragments.CalendarFragment;
import com.example.myapplicationtodolist.fragments.GraphicsFragment;
import com.example.myapplicationtodolist.fragments.HomeFragment;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements TaskAdapter.OnTaskListener{

    private BottomSheetMenu bottomSheetMenu;
    //private HomeFragment homeFragment;
    public static final String TAG = "SomeActivity";
    private Taches tasks;
    private Etiquettes tickets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDataBase();


        initBottomSheetMenu();
        activeButtonListenerBottomSheet();

        loadFragment(new HomeFragment(this, this.tickets));
    }




















    private void initDataBase(){
        this.tickets = new Etiquettes();
        this.tickets.init();
        this.tasks = new Taches();
        this.tasks.init();
        System.out.println("DATE: "+this.tasks.getTasks().get(0).getDate());
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
            loadFragment(new GraphicsFragment(this, this.tickets));
            bottomSheetMenu.setCollapsedBottomSheetMenu();
            bottomSheetMenu.visibilityMenuBottomSheetOnGraphicTracking();
        });
        bottomSheetMenu.buttonMainActivity.setOnClickListener(view -> {
            loadFragment(new HomeFragment(this,this.tickets));
            bottomSheetMenu.setCollapsedBottomSheetMenu();
        });
        bottomSheetMenu.buttonNextTask.setOnClickListener(view -> {
            loadFragment(new CalendarFragment(this,this, this.tickets));
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
    public void startActivityAddTask(View v, Intent intent){
        v.getContext().startActivity(intent);
    }


    @Override
    public void onTaskClick(int position, View view) {
        Log.d(TAG, "GetClicked");
        BottomSheetTask bottomSheetTask = new BottomSheetTask(view);
        bottomSheetTask.initBottomSheetDialog();
    }
}