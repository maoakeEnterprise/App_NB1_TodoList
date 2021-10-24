package com.example.myapplicationtodolist;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class BottomSheetMenu {

    private BottomSheetBehavior bottomSheetMenu;
    private final View view;
    private ImageButton buttonMenuBottomSheet;
    private ImageButton buttonAddBottomSheet;
    private View lineBottomSheet;
    private LinearLayout menuLinearLayoutBottomSheet;


    public BottomSheetMenu(View v) {

        View lineDropBottomSheet;

        this.view = v;
        lineDropBottomSheet = this.view.findViewById(R.id.line_drop_menu_bottom_sheet);
        lineDropBottomSheet.setVisibility(View.INVISIBLE);
        buttonMenuBottomSheet = this.view.findViewById(R.id.menu_button_bottom_sheet);
        buttonAddBottomSheet = this.view.findViewById(R.id.add_button_bottom_sheet);
        lineBottomSheet = this.view.findViewById(R.id.line_drop_menu_bottom_sheet);
        menuLinearLayoutBottomSheet = this.view.findViewById(R.id.linearlayout_menu_bottom_sheet);
    }

    public void showBottomSheet() {
        if (verifyViewNotNull()) {
            LinearLayout linearLayoutMenu = this.view.findViewById(R.id.bottom_sheet_menu_Container);
            this.bottomSheetMenu = BottomSheetBehavior.from(linearLayoutMenu);
        }
    }

    private boolean verifyViewNotNull(){
        return this.view!=null;
    }

    public void activateButtonActivity(){

        if(verifyViewNotNull()){

            //Creating an action on the button who show up the menu bottom sheet
            buttonMenuBottomSheet.setOnClickListener(view -> {
                bottomSheetMenu.setState(BottomSheetBehavior.STATE_EXPANDED);
            });

            lineBottomSheet.setOnClickListener(view -> {
                bottomSheetMenu.setState(BottomSheetBehavior.STATE_COLLAPSED);
            });

            buttonAddBottomSheet.setOnClickListener(view1 -> {
                startActivityAddTask(view1);
            });

            bottomSheetMenu.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                @Override
                public void onStateChanged(@NonNull View bottomSheet, int newState) {
                }

                @Override
                public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                    if(slideOffset > 0){
                        visibilityOnMenuBottomSheetOrLineBottomSheet(menuLinearLayoutBottomSheet,lineBottomSheet,true);
                    }
                    else if(slideOffset <= 0){
                        visibilityOnMenuBottomSheetOrLineBottomSheet(menuLinearLayoutBottomSheet,lineBottomSheet,false);
                    }
                }
            });
        }
    }

    private void visibilityOnMenuBottomSheetOrLineBottomSheet(LinearLayout menuLinear, View line, Boolean cas){
        if(cas){
            menuLinear.setVisibility(View.GONE);
            line.setVisibility(View.VISIBLE);
        }else{
            menuLinear.setVisibility(View.VISIBLE);
            line.setVisibility(View.INVISIBLE);
        }
    }

    private void startActivityAddTask(View view1){
        Intent intent = new Intent(view1.getContext(),AddTaskActivity.class);
        view1.getContext().startActivity(intent);
    }

}
