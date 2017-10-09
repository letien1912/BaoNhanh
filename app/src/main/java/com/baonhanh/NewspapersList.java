package com.baonhanh;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.Adapter.CardAdapterSelectIcon;
import com.Adapter.RecyclerViewOnClickListener;
import com.SettingPreferences.SettingActivity;
import com.model.LogoWebsiteItem;
import com.model.WebsiteAddress;

import java.util.ArrayList;

public class NewspapersList extends BaseActivity implements RecyclerViewOnClickListener.OnItemClickListener{


    private static final int NUMBER_PER_ROW = 2;
    private RecyclerView mRecyclerView;
    private ArrayList<LogoWebsiteItem> myLogoList;
    private CardAdapterSelectIcon myCardAdapterSelectIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_newspapers_list);
        Log.d("hello", "hello");

        setupWindowAnimations();
        setupActionBar();
        setuplisticon();
        CreateRecyclerView();

    }

    private void setupWindowAnimations() {
        // Re-enter transition is executed when returning to this activity
        Slide slideTransition = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            slideTransition = new Slide();
            slideTransition.setSlideEdge(Gravity.LEFT);
            slideTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
            getWindow().setReenterTransition(slideTransition);
            getWindow().setExitTransition(slideTransition);
        }
    }

    public  void setupActionBar(){
        activeToolbar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
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
            Intent it = new Intent(NewspapersList.this, SettingActivity.class);
            startActivity(it);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    boolean doubleClickBack = false;

    @Override
    public void onBackPressed() {
        if (doubleClickBack) {
            super.onBackPressed();
            finish();
            OpeningActivity.instance.finish();
            return;
        }

        doubleClickBack = true;
        Snackbar.make(findViewById(R.id.newsPaperGridRecyclerView),getString(R.string.back_to_exit), Snackbar.LENGTH_LONG)
                .setAction("EXIT NOW", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                        OpeningActivity.instance.finish();
                    }
                }).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleClickBack = false;
            }
        }, 2000);
    }

    public void CreateRecyclerView() {
        myLogoList = setuplisticon();
        mRecyclerView = (RecyclerView) findViewById(R.id.newsPaperGridRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, NUMBER_PER_ROW , GridLayoutManager.VERTICAL, false));
        mRecyclerView.addOnItemTouchListener(new RecyclerViewOnClickListener(NewspapersList.this, mRecyclerView, this));
        myCardAdapterSelectIcon = new CardAdapterSelectIcon(myLogoList, NewspapersList.this);
        mRecyclerView.setAdapter(myCardAdapterSelectIcon);

    }

    public static ArrayList<LogoWebsiteItem> setuplisticon() {
        ArrayList<LogoWebsiteItem> myLogoList = new ArrayList<>();
        myLogoList.add(new LogoWebsiteItem("VNExpress", R.drawable.express_icon));
        myLogoList.add(new LogoWebsiteItem("24h", R.drawable._24h_icon));
        myLogoList.add(new LogoWebsiteItem("Lao Động", R.drawable.laodong_icon));
        myLogoList.add(new LogoWebsiteItem("Pháp Luật", R.drawable.phapluat_icon));
        myLogoList.add(new LogoWebsiteItem("Tuổi Trẻ", R.drawable.tuoitre_icon));
        myLogoList.add(new LogoWebsiteItem("Thanh Niên", R.drawable.thanhnien_icon));
        myLogoList.add(new LogoWebsiteItem("Tinh Tế", R.drawable.tinhte_icon));
        return myLogoList;
    }


    @Override
    public void onItemClick(View v, int pos) {
        Intent intent = new Intent(NewspapersList.this, WebselectedActivity.class);
        intent.putExtra("Web", WebsiteAddress.values()[pos]);
        startActivity(intent);
    }

    @Override
    public void onItemLongClick(View v, int pos) {
        Log.d("Test long click ",pos+"");
    }


}
