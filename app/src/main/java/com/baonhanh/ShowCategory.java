package com.baonhanh;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.Adapter.CatelogyAdapter;
import com.Adapter.RecyclerViewOnClickListener;
import com.SettingPreferences.SettingActivity;
import com.baohanh.RssConnect.GetRssData;
import com.github.rahatarmanahmed.cpv.CircularProgressView;
import com.model.OnTaskCompleted;
import com.model.RssItems;
import com.model.WebsiteAddress;

import java.util.ArrayList;

public class ShowCategory extends BaseActivity implements OnItemClickListener, SwipeRefreshLayout.OnRefreshListener {

    private static final String LOG_TAG = ShowCategory.class.getSimpleName();

    private ArrayList<RssItems> newsPaperContent;
    private WebsiteAddress mwebsiteAddress;
    private RecyclerView recyclerView;
    private CircularProgressView progressView;
    private SwipeRefreshLayout refreshView;
    private CatelogyAdapter catelogyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_show_category);

        progressView = (CircularProgressView) findViewById(R.id.myProgressBar);

        Bundle bundle = getIntent().getExtras();
        String mUrlAddress = bundle.getString("address");
        String mUrlCaption = bundle.getString("caption");

                /*Toolbar*/
        Toolbar mToolbar = activeToolbar();
        mToolbar.setVisibility(View.VISIBLE);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(mUrlCaption);

                /*Create refreshing button*/
        refreshView = (SwipeRefreshLayout) findViewById(R.id.refreshpage_swipe);
        refreshView.setOnRefreshListener(this);
        refreshView.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE);

        mwebsiteAddress = (WebsiteAddress) bundle.getSerializable("websiteaddress");

        LoadContentToList(mUrlAddress);

    }


    private void LoadContentToList(String mUrlAddress) {
        GetRssData getData = new GetRssData(mUrlAddress,ShowCategory.this,progressView, new OnTaskCompleted() {
            @Override
            public void onTaskCompleted(ArrayList<RssItems> list) {
                newsPaperContent = new ArrayList<>(list);

                recyclerView = (RecyclerView) findViewById(R.id.catelogyRecyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(ShowCategory.this));
                recyclerView.addOnItemTouchListener(new RecyclerViewOnClickListener(ShowCategory.this, recyclerView, new RecyclerViewOnClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int pos) {
                        Bundle bd = new Bundle();
                        Intent intent = new Intent(ShowCategory.this, ShowContentHtmlActivity.class);
                        RssItems item = newsPaperContent.get(pos);
                        bd.putSerializable("rssitem", item);
                        bd.putSerializable("websiteaddress", mwebsiteAddress);
                        intent.putExtras(bd);
                        startActivity(intent);
                    }

                    @Override
                    public void onItemLongClick(View v, int pos) {

                    }
                }));
                catelogyAdapter = new CatelogyAdapter(newsPaperContent, ShowCategory.this);
                recyclerView.setAdapter(catelogyAdapter);
            }
        });
        getData.execute();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(ShowCategory.this, ShowContentHtmlActivity.class);
        RssItems item = newsPaperContent.get(position);
        intent.putExtra("ITEM", item);
        startActivity(intent);
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
            Intent it = new Intent(ShowCategory.this, SettingActivity.class);
            startActivity(it);
            return true;
        }else if (id == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    @Override
    public void onRefresh() {
        refreshView.postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshView.setRefreshing(false);
                catelogyAdapter.notifyDataSetChanged();
            }
        }, 2000);
    }
}