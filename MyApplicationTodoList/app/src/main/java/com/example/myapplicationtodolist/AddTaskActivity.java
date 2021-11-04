package com.example.myapplicationtodolist;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class AddTaskActivity extends AppCompatActivity {

    private ImageView returnArrow;
    private EditText nameTask;
    private EditText describeTask;
    private CardView buttonValidate;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_add_things_to_do);


        this.initButtonOfTheActivity();
        this.clickListenerAddTask();

    }

    @Override
    public void finish() {
        super.finish();
        //overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }

    private void clickListenerAddTask(){
        returnArrow.setOnClickListener(view -> {
            finish();
        });

        buttonValidate.setOnClickListener(view ->{

        });
    }
    private void initButtonOfTheActivity(){
        returnArrow = findViewById(R.id.returnArrow);
        nameTask = findViewById(R.id.editTexttaskName);
        describeTask = findViewById(R.id.editTextdescriberTask);
        buttonValidate = findViewById(R.id.buttonValidate);
    }
}
