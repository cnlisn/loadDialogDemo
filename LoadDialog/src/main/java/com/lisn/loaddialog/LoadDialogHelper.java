package com.lisn.loaddialog;

import android.content.Context;
import android.text.TextUtils;

/**
 * @author : lishan
 * @e-mail : cnlishan@163.com
 * @date : 2019-11-07 17:31
 * @desc :
 */
public class LoadDialogHelper {

    private static CustomDialog mLoadingDialog;

    private LoadDialogHelper() {
    }

//    private static class SingletonClassInstance {
//        private static final LoadDialogHelper instance = new LoadDialogHelper();
//    }
//
//    public static LoadDialogHelper getInstance() {
//        return SingletonClassInstance.instance;
//    }


    public static class Builder {
        private boolean CanceledOnTouchOutside;
        private String msg;
        private Context context;

        public Builder setCanceled(boolean CanceledOnTouchOutside) {
            this.CanceledOnTouchOutside = CanceledOnTouchOutside;
            return this;
        }

        public Builder setMsg(String msg) {
            this.msg = msg;
            return this;
        }

        public Builder setContext(Context context) {
            this.context = context;
            return this;
        }

        public LoadDialogHelper build() {
            return new LoadDialogHelper(this);
        }
    }

    public LoadDialogHelper(Builder builder) {
        String msg = builder.msg;
        boolean CanceledOnTouchOutside = builder.CanceledOnTouchOutside;
        Context context = builder.context;
        if (context == null) {
            throw new NullPointerException("context == null");
        }
        mLoadingDialog = new CustomDialog(context);
        mLoadingDialog.setCanceledOnTouchOutside(CanceledOnTouchOutside);

        if (!TextUtils.isEmpty(msg)) {
            mLoadingDialog.setText(msg);
        } else {
            mLoadingDialog.setText("加载中...");
        }
    }


    public void show() {
        if (mLoadingDialog != null) {
            mLoadingDialog.show();
        }
    }

    public void dismiss() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
        }
    }
}
