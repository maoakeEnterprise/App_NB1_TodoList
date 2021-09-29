package com.example.myapplicationtodolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplicationtodolist.fragments.HomeFragment;
import com.example.myapplicationtodolist.fragments.ModalBottomSheetFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button test;
    ModalBottomSheetFragment bottomSheetFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //injecter le fragment dans la boite (fragment container)
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, new HomeFragment());
        transaction.addToBackStack(null);
        transaction.commit();
        test =(Button)findViewById(R.id.test_bottom_sheet);
        test.setOnClickListener(this);


    }


    public void onClick(View view){
        Toast.makeText(this, "test",Toast.LENGTH_SHORT);
        if(view.getId() == test.getId()){
            Toast.makeText(this, "test",Toast.LENGTH_SHORT);
            bottomSheetFragment = new ModalBottomSheetFragment();
            bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
        }
    }
}