package com.example.ralucaplugariu.myapplication;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by raluca.plugariu on 21.03.2018.
 */

public class Preferences extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref);
    }
}

