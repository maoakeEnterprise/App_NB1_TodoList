package com.example.myapplicationtodolist;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class BottomSheetMenu {

    private BottomSheetBehavior bottomSheetMenu;
    private final View view;
    private final ImageButton buttonMenuBottomSheet;
    private final View lineBottomSheet;
    private final LinearLayout menuLinearLayoutBottomSheet;

    public ImageButton buttonAddBottomSheet;
    public LinearLayout buttonGraphTracking;
    public LinearLayout buttonMainActivity;
    public LinearLayout buttonNextTask;
    public LinearLayout buttonProject;
    public LinearLayout buttonTickets;
    public LinearLayout buttonSettings;
    public ImageView buttonAddProject;


    public BottomSheetMenu(View v) {

        this.view = v;
        buttonMenuBottomSheet = this.view.findViewById(R.id.menu_button_bottom_sheet);
        buttonAddBottomSheet = this.view.findViewById(R.id.add_button_bottom_sheet);
        lineBottomSheet = this.view.findViewById(R.id.line_drop_menu_bottom_sheet);
        lineBottomSheet.setVisibility(View.INVISIBLE);
        menuLinearLayoutBottomSheet = this.view.findViewById(R.id.linearlayout_menu_bottom_sheet);
        buttonGraphTracking = this.view.findViewById(R.id.buttonGraphTrackingActivity);
        buttonMainActivity = this.view.findViewById(R.id.buttonMainActivity);
        buttonNextTask = this.view.findViewById(R.id.buttonNextTaskActivity);
        buttonProject = this.view.findViewById(R.id.buttonProjectActivity);
        buttonTickets = this.view.findViewById(R.id.buttonTicketsActivity);
        buttonSettings = this.view.findViewById(R.id.buttonSettingsActivity);
        buttonAddProject = this.view.findViewById(R.id.add_button_project);
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
    public void setCollapsedBottomSheetMenu(){bottomSheetMenu.setState(BottomSheetBehavior.STATE_COLLAPSED);}
}
