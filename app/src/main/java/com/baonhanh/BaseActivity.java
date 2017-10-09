package com.baonhanh;


import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by Le on 16-Jan-16.
 */
public class BaseActivity extends AppCompatActivity {
    private Toolbar mToolbar;

    protected Toolbar activeToolbar() {
        if (mToolbar == null) {
            mToolbar = (Toolbar) findViewById(R.id.newSpaperList_toolbar);
            if (mToolbar != null)
                setSupportActionBar(mToolbar);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return mToolbar;
    }

}
