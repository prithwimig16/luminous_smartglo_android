package tfl.smartglow.utils;

import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;

import static android.content.Context.MODE_PRIVATE;

public class Utils {

    private static Utils _singletonObj = null;

    ProgressDialog progressDialog;

    public static Utils getInstance() {
        if (_singletonObj == null) {
            _singletonObj = new Utils();
        }
        return _singletonObj;
    }

    public static void alert(String message, Context context) {

        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("SmartGlo");

        alertDialog.setMessage(message);
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        if(!((Activity) context).isFinishing())
        {
            //show dialog
            alertDialog.show();
        }



    }
    public static boolean saveValueInPref(String key, String value) {
        if (key != null && value != null) {

            SharedPreferences pref = Config.getSharedInstance().applicationContext.getSharedPreferences("SmartGlo", Application.MODE_PRIVATE);
            pref.edit().putString(key, value).apply();
            return true;
        } else {
            return false;
        }

    }



    public static String getValueFromPref(String key) {
        if (key != null) {
            SharedPreferences pref = Config.getSharedInstance().applicationContext.getSharedPreferences("SmartGlo", Application.MODE_PRIVATE);
            return pref.getString(key, null);
        }

        return "";
    }
}
