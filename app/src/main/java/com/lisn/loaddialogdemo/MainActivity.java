package com.lisn.loaddialogdemo;


import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lisn.loaddialog.CustomDialog;
import com.lisn.loaddialog.LoadDialogHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void xx(View view) {

        final CustomDialog dialog = new CustomDialog(this);
        dialog.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
            }
        }, 5000);
    }

    public void xxx(View view) {
//        Dialog loadingDialog = LoadingDialogHelper.getLoadingDialog(this, true);
//
//        LoadingDialogHelper.showLoadingDialog(loadingDialog);

        LoadDialogHelper dialogHelper = new LoadDialogHelper.Builder()
                .setCanceled(true)
                .setContext(this)
                .setMsg("正在加载中...")
                .build();
        dialogHelper.show();

        view.postDelayed(new Runnable() {
            @Override
            public void run() {
//                LoadingDialogHelper.hideLoadingDialog(loadingDialog);
                dialogHelper.dismiss();
            }
        }, 3000);




    }
}
