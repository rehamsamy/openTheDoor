package com.openthedoor.utils;

import android.app.ProgressDialog;
import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;


/**
 * Created by Mahmoud on 10/16/17.
 */

public class DialogUtil {

    public DialogUtil() {
    }

    public static ProgressDialog showProgressDialog(Context context, String message, boolean cancelable) {
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setMessage(message);
        dialog.setCancelable(cancelable);
        dialog.show();
        return dialog;
    }


    public static MaterialDialog  showMaterialDialog(Context context,String title, String content, String pos, String neg,MaterialDialog.SingleButtonCallback posCallbak,MaterialDialog.SingleButtonCallback negCallback){
       MaterialDialog dialog=new MaterialDialog.Builder(context)
       .title(title)
       .content(content)
       .positiveText(pos)
       .negativeText(neg)
       .onNegative(negCallback)
       .onPositive(posCallbak)
       .show();

       return dialog;
    }
}
