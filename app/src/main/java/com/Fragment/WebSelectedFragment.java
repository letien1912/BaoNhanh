package com.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.baonhanh.R;
import com.baonhanh.ShowCategory;
import com.model.Variables;
import com.model.WebsiteAddress;

public class WebSelectedFragment extends Fragment implements AdapterView.OnItemClickListener {

    private static final int NUMBER_PER_ROW = 2;

    private String[] mUrlCaption;
    private String[] mUrlAddress;
    private WebsiteAddress websiteAddress;

    private static int LISTVIEW_INDEX_FROM_1 = 1;

    public static WebSelectedFragment newInstance(Bundle bd) {
        WebSelectedFragment fragment = new WebSelectedFragment();
        fragment.setArguments(bd);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_web_selected_fragment, container, false);

//        Bundle typeWebAddress = getActivity().getIntent().getExtras();
//        websiteAddress = (WebsiteAddress) typeWebAddress.get("Web");
        Bundle bd = this.getArguments();
        websiteAddress = (WebsiteAddress) bd.get("Web");
        getUrlFromMainSite();

//        mRecyclerView = (RecyclerView) view.findViewById(R.id.webselect_recyclerview);
//        CreateRecyclerView();

        ListView captionListView = (ListView) view.findViewById(R.id.linkNameListview);
        captionListView.setOnItemClickListener(this);

        ArrayAdapter<String> webSiteArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, mUrlCaption);
        captionListView.setAdapter(webSiteArrayAdapter);

        return view;
    }

//    private void CreateRecyclerView() {
//        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), NUMBER_PER_ROW, GridLayoutManager.VERTICAL, false));
//        mRecyclerView.addOnItemTouchListener(new RecyclerViewOnClickListener(getActivity(), mRecyclerView, this));
//        WebSelectedAdapterCardView selectedAdapterCardView = new WebSelectedAdapterCardView(mUrlCaption, mUrlAddress, getActivity());
//        mRecyclerView.setAdapter(selectedAdapterCardView);
//    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

//    @Override
//    public void onItemClick(View v, int pos) {
//
//        String mAddressString = mUrlAddress[pos];
//        String mCaptionString = mUrlCaption[pos];
//
//        Intent intent = new Intent(getActivity(), ShowCategory.class);
//        Bundle bd = new Bundle();
//        bd.putString("address", mAddressString);
//        bd.putString("caption", mCaptionString);
//        bd.putSerializable("websiteaddress", websiteAddress);
//        intent.putExtras(bd);
//        startActivity(intent);
//    }
//
//    @Override
//    public void onItemLongClick(View v, int pos) {
//
//    }

    private void getUrlFromMainSite() {

        switch (websiteAddress) {
            case _24H:
                mUrlCaption = new String[Variables._24H_ADDRESS.length - LISTVIEW_INDEX_FROM_1];
                mUrlAddress = new String[Variables._24H_CAPTION.length - LISTVIEW_INDEX_FROM_1];
                addUrl(Variables._24H_ADDRESS, Variables._24H_CAPTION);
                break;
            case VNEXPRESS:
                mUrlAddress = new String[Variables.VNEXPRESS_ADDRESS.length - LISTVIEW_INDEX_FROM_1];
                mUrlCaption = new String[Variables.VNEXPRESS_CAPTION.length - LISTVIEW_INDEX_FROM_1];
                addUrl(Variables.VNEXPRESS_ADDRESS, Variables.VNEXPRESS_CAPTION);
                break;
            case LAODONG:
                mUrlAddress = new String[Variables.LAPDONG_ADDRESS.length - LISTVIEW_INDEX_FROM_1];
                mUrlCaption = new String[Variables.LAODONG_CAPTION.length - LISTVIEW_INDEX_FROM_1];
                addUrl(Variables.LAPDONG_ADDRESS, Variables.LAODONG_CAPTION);
                break;
            case PHAPLUAT:
                mUrlAddress = new String[Variables.PHAPLUAT_ADDRESS.length - LISTVIEW_INDEX_FROM_1];
                mUrlCaption = new String[Variables.PHAPLUAT_CAPTION.length - LISTVIEW_INDEX_FROM_1];
                addUrl(Variables.PHAPLUAT_ADDRESS, Variables.PHAPLUAT_CAPTION);
                break;
            case TUOITRE:
                mUrlAddress = new String[Variables.TUOITRE_ADDRESS.length - LISTVIEW_INDEX_FROM_1];
                mUrlCaption = new String[Variables.TUOITRE_CAPTION.length - LISTVIEW_INDEX_FROM_1];
                addUrl(Variables.TUOITRE_ADDRESS, Variables.TUOITRE_CAPTION);
                break;
            case THANHNIEN:
                mUrlAddress = new String[Variables.THANHNIEN_ADDRESS.length - LISTVIEW_INDEX_FROM_1];
                mUrlCaption = new String[Variables.THANHNIEN_CAPTION.length - LISTVIEW_INDEX_FROM_1];
                addUrl(Variables.THANHNIEN_ADDRESS, Variables.THANHNIEN_CAPTION);
                break;
            case TINHTE:
                mUrlAddress = new String[Variables.TINHTE_ADDRESS.length - LISTVIEW_INDEX_FROM_1];
                mUrlCaption = new String[Variables.TINHTE_CAPTION.length - LISTVIEW_INDEX_FROM_1];
                addUrl(Variables.TINHTE_ADDRESS, Variables.TINHTE_CAPTION);
            default:
                break;

        }
    }

    private void addUrl(String address[], String caption[]) {
        for (int i = LISTVIEW_INDEX_FROM_1; i < address.length; i++) { /*lay index tu vi tri so 1*/
            mUrlAddress[i - LISTVIEW_INDEX_FROM_1] = address[i];
            mUrlCaption[i - LISTVIEW_INDEX_FROM_1] = caption[i];
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String mAddressString = mUrlAddress[position];
        String mCaptionString = mUrlCaption[position];

        Intent intent = new Intent(getActivity(), ShowCategory.class);
        Bundle bd = new Bundle();
        bd.putString("address", mAddressString);
        bd.putString("caption", mCaptionString);
        bd.putSerializable("websiteaddress", websiteAddress);
        intent.putExtras(bd);
        startActivity(intent);
    }


}
