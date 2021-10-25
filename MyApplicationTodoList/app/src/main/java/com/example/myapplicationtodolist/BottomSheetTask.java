package com.example.myapplicationtodolist;

import android.view.View;
import android.widget.LinearLayout;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class BottomSheetTask {
    public BottomSheetDialog bottomSheetDialogTask;
    private View view;

    public BottomSheetTask(View view){
        this.view = view;
    }

    public void initBottomSheetDialog() {
        if (verifyViewNotNull()) {
            bottomSheetDialogTask = new BottomSheetDialog(view.getContext());
        }
    }

    private boolean verifyViewNotNull(){
        return this.view!=null;
    }
}
