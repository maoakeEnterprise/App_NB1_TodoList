package com.example.myapplicationtodolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.myapplicationtodolist.fragments.HomeFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity{

    private BottomSheetBehavior test;
    private LinearLayout test2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        //injecter le fragment dans la boite (fragment container)
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, new HomeFragment());
        transaction.addToBackStack(null);
        transaction.commit();



    }

    private void init(){
        this.test2 = findViewById(R.id.bottom_sheet_menu_Container);
        this.test = BottomSheetBehavior.from(test2);
    }

}