package com.example.myapplicationtodolist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class BottomSheetMenu {

    private BottomSheetBehavior bottomSheetMenu;
    private LinearLayout linearLayoutMenu;
    private View view;

    public BottomSheetMenu(View v){
        this.view = v;
        this.linearLayoutMenu = this.view.findViewById(R.id.bottom_sheet_menu_Container);
        this.bottomSheetMenu = BottomSheetBehavior.from(linearLayoutMenu);

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
