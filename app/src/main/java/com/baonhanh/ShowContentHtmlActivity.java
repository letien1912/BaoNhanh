package com.baonhanh;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AccelerateInterpolator;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.SettingPreferences.SeekBarPreferences;
import com.SettingPreferences.SettingActivity;
import com.baohanh.RssConnect.SetWebViewFromHtml;
import com.model.RssItems;
import com.model.WebsiteAddress;

public class ShowContentHtmlActivity extends BaseActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
    private WebView myWebView;
    private WebsiteAddress mywebsiteAddress;
    private Toolbar mytoolbar;
    private int FONT_SIZE  = 15;

    private static final String SAVE_PREF = "save reference";
    private static final String SAVE_SEEK = "save seek";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_show_content_htlm);

        mytoolbar = activeToolbar();
        mytoolbar.animate().translationY(mytoolbar.getBottom()).setInterpolator(new AccelerateInterpolator()).start();

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        pref.registerOnSharedPreferenceChangeListener(this);

        Bundle bundle = getIntent().getExtras();
        mywebsiteAddress = (WebsiteAddress) bundle.getSerializable("websiteaddress");
        RssItems rssItems = (RssItems) bundle.getSerializable("rssitem");

        setSupportActionBar(mytoolbar);
        getSupportActionBar().setTitle(mywebsiteAddress.toString());

        myWebView = (WebView) findViewById(R.id.ShowHtlmContentWebView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setAppCacheEnabled(false);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setGeolocationEnabled(false);
        webSettings.setNeedInitialFocus(false);
        webSettings.setSaveFormData(false);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDefaultFontSize(loadReference());
        myWebView.setScrollbarFadingEnabled(false);
        myWebView.setScrollBarStyle(myWebView.SCROLLBARS_OUTSIDE_OVERLAY);
        myWebView.setInitialScale(1);
        myWebView.setWebChromeClient(new WebChromeClient());

        SetWebViewFromHtml setWebViewFromHtml = new SetWebViewFromHtml(myWebView, rssItems.getmLink(), mywebsiteAddress, getApplicationContext());
        setWebViewFromHtml.execute();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent it = new Intent(ShowContentHtmlActivity.this, SettingActivity.class);
            startActivity(it);
            return true;
        } else if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        FONT_SIZE = sharedPreferences.getInt("seek", 0);
        myWebView.getSettings().setDefaultFontSize(FONT_SIZE);
        saveReference(FONT_SIZE);
    }

    public void saveReference(int seekSize) {
        SharedPreferences pref = getSharedPreferences(SAVE_PREF, MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        edit.putInt(SAVE_SEEK, seekSize);
        edit.commit();
    }

    public int loadReference() {
        SharedPreferences pref = getSharedPreferences(SAVE_PREF, MODE_PRIVATE);
        PreferenceManager.setDefaultValues(this,R.xml.mysetting,false);
        int fontsize = pref.getInt(SAVE_SEEK,0);
        return fontsize==0? SeekBarPreferences.SEEKBAR_MAX_VALUE + 15 : fontsize;
    }
}
