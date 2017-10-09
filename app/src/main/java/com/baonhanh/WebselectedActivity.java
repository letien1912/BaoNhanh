package com.baonhanh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.Adapter.NavigationDrawerListAdapter;
import com.Fragment.PageFragmentPaperAdapter;
import com.SettingPreferences.SettingActivity;
import com.model.SlidingTabLayout;
import com.model.WebsiteAddress;

/**
 * Created by Le on 17-Jan-16.
 */
public class WebselectedActivity extends BaseActivity {
    private Toolbar mtoolbar;
    private DrawerLayout mDrawerLayout;
    private WebsiteAddress websiteAddress;
    private PageFragmentPaperAdapter adapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_webselected_activiy);

        mtoolbar = activeToolbar();


        Bundle typeWebAddress = getIntent().getExtras();
        websiteAddress = (WebsiteAddress) typeWebAddress.get("Web");

        viewPager = (ViewPager) findViewById(R.id.viewpager2);
        Bundle fragmentBundle = new Bundle();
        fragmentBundle.putSerializable("Web",websiteAddress);

        adapter = new PageFragmentPaperAdapter(getSupportFragmentManager(), WebselectedActivity.this, fragmentBundle);
        viewPager.setAdapter(adapter);


        SlidingTabLayout tabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tab_toolbar);
        tabLayout.setViewPager(viewPager);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout2);
        CreateNavitionView(mDrawerLayout, WebselectedActivity.this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent it = new Intent(WebselectedActivity.this, SettingActivity.class);
            startActivity(it);
            return true;
        } else if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    public void CreateNavitionView(final DrawerLayout mDrawerLayout, final Activity activity) {
        final ListView mDrawerList = (ListView) findViewById(R.id.navigation_listview);
        /** Tạo Custom listview Trong drawerlayout*/
        NavigationDrawerListAdapter navigationDrawerListAdapter = new NavigationDrawerListAdapter(getApplicationContext(), NewspapersList.setuplisticon());
        mDrawerList.setAdapter(navigationDrawerListAdapter);
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mDrawerLayout.closeDrawers();
                finish();
                Intent intent = new Intent(WebselectedActivity.this, WebselectedActivity.class);
                intent.putExtra("Web", WebsiteAddress.values()[position]);
                startActivity(intent);

            }
        });

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(activity, mDrawerLayout, mtoolbar, R.string.open_drawer, R.string.close_drawer) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

    }

}
