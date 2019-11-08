package com.lisn.loaddialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.lisn.loaddialog.View.CircleProgress;

/**
 * Author: LiShan
 * Time: 2019-11-07
 * Description:
 */

public class CustomDialog extends ProgressDialog {

    private CircleProgress dialog_progressBar;

    private TextView tv_load_dialog;
    private String msg;

    public CircleProgress getDialog_progressBar() {
        return dialog_progressBar;
    }

    public TextView getTv_load_dialog() {
        return tv_load_dialog;
    }

    public CustomDialog(Context context) {
        this(context, R.style.CustomDialog);
    }

    public CustomDialog(Context context, int theme) {
        super(context, theme);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        init(getContext());
    }

    private void init(Context context) {
        // 设置不可取消 点击其他区域不能取消
//        setCancelable(false);
//        setCanceledOnTouchOutside(false);

        setContentView(R.layout.load_dialog);
        WindowManager.LayoutParams params = this.getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        this.getWindow().setAttributes(params);


        dialog_progressBar = getWindow().findViewById(R.id.dialog_progressBar);
        tv_load_dialog = getWindow().findViewById(R.id.tv_load_dialog);

        if (tv_load_dialog != null&& !TextUtils.isEmpty(msg))
            tv_load_dialog.setText(msg);
    }

    public void setText(String msg) {
        this.msg = msg;
    }


}
