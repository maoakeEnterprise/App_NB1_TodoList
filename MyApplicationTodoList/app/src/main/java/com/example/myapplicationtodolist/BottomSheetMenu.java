package com.example.myapplicationtodolist;

import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class BottomSheetMenu {

    private BottomSheetBehavior bottomSheetMenu;
    private final View view;

    public BottomSheetMenu(View v) {
        this.view = v;

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
            bottomSheetMenu.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                @Override
                public void onStateChanged(@NonNull View bottomSheet, int newState) {

                }

                @Override
                public void onSlide(@NonNull View bottomSheet, float slideOffset) {

                }
            });
        }
    }

}
