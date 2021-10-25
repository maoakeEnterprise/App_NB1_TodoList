package com.example.myapplicationtodolist;

import android.view.LayoutInflater;
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
        View bottomSheetView;
        if (verifyViewNotNull()) {
            bottomSheetDialogTask = new BottomSheetDialog(view.getContext());
            bottomSheetView = LayoutInflater.from(view.getContext()
                    .getApplicationContext())
                    .inflate(
                            R.layout.layout_bottom_sheet_task,
                            (LinearLayout)view.findViewById(R.id.bottom_sheet_task_container)
                            );
            bottomSheetDialogTask.setContentView(bottomSheetView);
            bottomSheetDialogTask.show();
        }
    }

    private boolean verifyViewNotNull(){
        return this.view!=null;
    }
}
