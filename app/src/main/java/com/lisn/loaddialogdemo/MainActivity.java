package com.lisn.loaddialogdemo;


import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.lisn.loaddialog.CustomDialog;
import com.lisn.loaddialog.LoadDialogHelper;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View ib_1 = findViewById(R.id.ib_1);
        View ib_2 = findViewById(R.id.ib_2);
        View ib_3 = findViewById(R.id.ib_3);


        ib_1.setOnTouchListener(listener);
        ib_2.setOnTouchListener(listener);
        ib_3.setOnTouchListener(listener);
    }

    /**
     * ACTION_POINTER_DOWN  ACTION_POINTER_UP 非主要的指针(手指)按下或抬起
     * 当有手指按下时，如果检测到已经有手指按下了，而且还没抬起，那么，这次按下的手指，就是非主要的；
     * 抬起也是同理：当检测到有手指抬起，如果此时还有别的手指没抬起，那么这次的抬起就是非主要的；
     */
    View.OnTouchListener listener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int i = event.getAction() & MotionEvent.ACTION_MASK;
            //i==actionMasked  上边写法和下边一样
            int actionMasked = event.getActionMasked();
            switch (actionMasked) {
                case MotionEvent.ACTION_DOWN:
                    Log.e(TAG, "onTouch: ACTION_DOWN " + v.getId());
                    break;
                case MotionEvent.ACTION_MOVE:
                    Log.e(TAG, "onTouch: ACTION_MOVE " + v.getId());
                    break;
                case MotionEvent.ACTION_CANCEL:
                    Log.e(TAG, "onTouch: ACTION_CANCEL " + v.getId());
                    break;
                case MotionEvent.ACTION_UP:
                    Log.e(TAG, "onTouch: ACTION_UP " + v.getId());
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    Log.e(TAG, "onTouch: ACTION_POINTER_DOWN " + v.getId());
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    Log.e(TAG, "onTouch: ACTION_POINTER_UP " + v.getId());
                    break;
            }
            return false;
        }
    };

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
