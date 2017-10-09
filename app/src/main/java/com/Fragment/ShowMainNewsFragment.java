package com.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import com.Adapter.CatelogyAdapter;
import com.Adapter.RecyclerViewOnClickListener;
import com.baohanh.RssConnect.GetRssData;
import com.baonhanh.R;
import com.baonhanh.ShowContentHtmlActivity;
import com.github.rahatarmanahmed.cpv.CircularProgressView;
import com.model.OnTaskCompleted;
import com.model.RssItems;
import com.model.Variables;
import com.model.WebsiteAddress;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ShowMainNewsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ShowMainNewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShowMainNewsFragment extends Fragment implements AdapterView.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener {
    private ArrayList<RssItems> newsPaperContent;
    private RecyclerView recyclerView;

    private OnFragmentInteractionListener mListener;
    private WebsiteAddress websiteAddress;
    private String mUrlCaption;
    private String mUrlAddress;
    private CircularProgressView progressView;
    private Toolbar mToolbar;
    private SwipeRefreshLayout refreshView;
    private CatelogyAdapter catelogyAdapter;

    // TODO: Rename and change types and number of parameters
    public static ShowMainNewsFragment newInstance(Bundle bd) {
        ShowMainNewsFragment fragment = new ShowMainNewsFragment();
        fragment.setArguments(bd);
        return fragment;

    }

    public ShowMainNewsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_show_category, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.catelogyRecyclerView);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mToolbar = (Toolbar) view.findViewById(R.id.newSpaperList_toolbar);
        mToolbar.setVisibility(View.GONE);

                    /*Create refreshing button*/
        refreshView = (SwipeRefreshLayout) view.findViewById(R.id.refreshpage_swipe);
        refreshView.setOnRefreshListener(this);
        refreshView.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE);

        Bundle typeWebAddress = this.getArguments();
        websiteAddress = (WebsiteAddress) typeWebAddress.get("Web");
        
             /*Create progressbar*/
        progressView = (CircularProgressView) view.findViewById(R.id.myProgressBar);
        progressView.startAnimation();



        getUrlFromMainSite();
        LoadContentToList(mUrlAddress, recyclerView);
        return view;
    }

    private void getUrlFromMainSite() {

        switch (websiteAddress) {
            case _24H:
                mUrlCaption = Variables._24H_ADDRESS[0];
                mUrlAddress = Variables._24H_ADDRESS[0];
                break;
            case VNEXPRESS:
                mUrlAddress = Variables.VNEXPRESS_ADDRESS[0];
                mUrlCaption = Variables.VNEXPRESS_CAPTION[0];
                break;
            case LAODONG:
                mUrlAddress = Variables.LAPDONG_ADDRESS[0];
                mUrlCaption = Variables.LAODONG_CAPTION[0];
                break;
            case PHAPLUAT:
                mUrlAddress = Variables.PHAPLUAT_ADDRESS[0];
                mUrlCaption = Variables.PHAPLUAT_CAPTION[0];
                break;
            case TUOITRE:
                mUrlAddress = Variables.TUOITRE_ADDRESS[0];
                mUrlCaption = Variables.TUOITRE_CAPTION[0];
                break;
            case THANHNIEN:
                mUrlAddress = Variables.THANHNIEN_ADDRESS[0];
                mUrlCaption = Variables.THANHNIEN_CAPTION[0];
                break;
            case TINHTE:
                mUrlAddress = Variables.TINHTE_ADDRESS[0];
                mUrlCaption = Variables.TINHTE_CAPTION[0];
                break;
            default:
                break;
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void LoadContentToList(String mUrlAddress, final RecyclerView recyclerView) {
        Log.d(ShowMainNewsFragment.class.getSimpleName(), mUrlAddress);
        GetRssData getData = new GetRssData(mUrlAddress, getActivity(), progressView, new OnTaskCompleted() {
            @Override
            public void onTaskCompleted(ArrayList<RssItems> list) {
                newsPaperContent = new ArrayList<>(list);

                LinearLayoutManager linearLayout = new LinearLayoutManager(getActivity());
                linearLayout.setOrientation(LinearLayout.VERTICAL);
                recyclerView.setLayoutManager(linearLayout);


                recyclerView.addOnItemTouchListener(new RecyclerViewOnClickListener(getActivity(), recyclerView, new RecyclerViewOnClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int pos) {
                        Bundle bd = new Bundle();
                        Intent intent = new Intent(getActivity(), ShowContentHtmlActivity.class);
                        RssItems item = newsPaperContent.get(pos);
                        bd.putSerializable("rssitem", item);
                        bd.putSerializable("websiteaddress", websiteAddress);
                        intent.putExtras(bd);
                        startActivity(intent);
                    }

                    @Override
                    public void onItemLongClick(View v, int pos) {

                    }
                }));
                catelogyAdapter = new CatelogyAdapter(newsPaperContent, getActivity());
                recyclerView.setAdapter(catelogyAdapter);
            }
        });
        getData.execute();
    }

    @Override
    public void onDestroy() {
        recyclerView.setAdapter(null);
        super.onDestroy();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(), ShowContentHtmlActivity.class);
        RssItems item = newsPaperContent.get(position);
        intent.putExtra("ITEM", item);
        startActivity(intent);
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
