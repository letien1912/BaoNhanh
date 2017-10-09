package com.SettingPreferences;

import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

import com.baonhanh.R;

/**
 * Created by Le on 29-Jan-16.
 */
public class SettingActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentTransaction trans = getFragmentManager().beginTransaction();
        trans.replace(android.R.id.content, new MyPrefFragment()).commit();
    }


    private class MyPrefFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

        private boolean isChangeNightMode = true;
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.mysetting);

        }

        @Override
        public void onResume() {
            super.onResume();

            SharedPreferences preferences = getPreferenceManager().getSharedPreferences();
            onSharedPreferenceChanged(preferences, "seek");
            /***Dung` sau */
            onSharedPreferenceChanged(preferences, "switchpref");
            preferences.registerOnSharedPreferenceChangeListener(this);


        }

        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

            switch (key) {
                case "seek":
                    int value = sharedPreferences.getInt(key, 0);
                    break;
                default:break;

            }
        }

        @Override
        public void onPause() {
            super.onPause();
            SharedPreferences prefs = getPreferenceManager().getSharedPreferences();
            prefs.unregisterOnSharedPreferenceChangeListener(this);
        }
    }

}
