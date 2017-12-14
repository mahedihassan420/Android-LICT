package com.hisoft.ovi.phoneverification.preference;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Invariant on 9/17/17.
 */

public class ApplicationPreferences {
    private SharedPreferences appSharedPrefs;
    private SharedPreferences.Editor prefsEditor;

    public ApplicationPreferences(Context context) {
        this.appSharedPrefs = context.getSharedPreferences(context.getPackageName(),
                Context.MODE_PRIVATE);
        this.prefsEditor = appSharedPrefs.edit();
    }

    public void setValue(String keyName,String value) {
        prefsEditor.putString(keyName, value);
        prefsEditor.commit();
    }

    public String getValue(String keyName) {
        return appSharedPrefs.getString(keyName, "");
    }

}
