package com.example.myapplicationtodolist;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplicationtodolist.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomSheetMenu bottomSheetMenu = new BottomSheetMenu(findViewById(R.id.bottom_sheet_menu_Container));
        bottomSheetMenu.showBottomSheet();


        //injecter le fragment dans la boite (fragment container)
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, new HomeFragment());
        transaction.addToBackStack(null);
        transaction.commit();



    }


}