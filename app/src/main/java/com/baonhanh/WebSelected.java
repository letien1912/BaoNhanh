//package com.baonhanh;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.widget.Toolbar;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//
//import com.model.Variables;
//import com.model.WebsiteAddress;
//
//public class WebSelected extends BaseActivity implements AdapterView.OnItemClickListener {
//
//    private ArrayAdapter<String> webSiteArrayAdapter;
//    private ListView captionListView;
//    private String[] mUrlCaption;
//    private String[] mUrlAddress;
//    private WebsiteAddress websiteAddress;
//    private Toolbar mtoolbar;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.layout_web_selected_fragment);
//        mtoolbar = activeToolbar();
//
//        Bundle typeWebAddress = getIntent().getExtras();
//        websiteAddress = (WebsiteAddress) typeWebAddress.get("Web");
//
//        getUrlFromMainSite();
//        captionListView = (ListView) findViewById(R.id.linkNameListview);
//        captionListView.setOnItemClickListener(this);
//
//        webSiteArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mUrlCaption);
//        captionListView.setAdapter(webSiteArrayAdapter);
//
//    }
//
//    private void getUrlFromMainSite() {
//
//        switch (websiteAddress) {
//            case _24H:
//                mUrlCaption = new String[Variables._24H_ADDRESS.length];
//                mUrlAddress = new String[Variables._24H_CAPTION.length];
//                addUrl(Variables._24H_ADDRESS, Variables._24H_CAPTION);
//                break;
//            case VNEXPRESS:
//                mUrlAddress = new String[Variables.VNEXPRESS_ADDRESS.length];
//                mUrlCaption = new String[Variables.VNEXPRESS_CAPTION.length];
//                addUrl(Variables.VNEXPRESS_ADDRESS, Variables.VNEXPRESS_CAPTION);
//                break;
//            case LAODONG:
//                mUrlAddress = new String[Variables.LAPDONG_ADDRESS.length];
//                mUrlCaption = new String[Variables.LAODONG_CAPTION.length];
//                addUrl(Variables.LAPDONG_ADDRESS, Variables.LAODONG_CAPTION);
//                break;
//            case SOHA:
//                mUrlAddress = new String[Variables.SOHA_ADDRESS.length];
//                mUrlCaption = new String[Variables.SOHA_CAPTION.length];
//                addUrl(Variables.SOHA_ADDRESS, Variables.SOHA_CAPTION);
//                break;
//            case PHAPLUAT:
//                mUrlAddress = new String[Variables.PHAPLUAT_ADDRESS.length];
//                mUrlCaption = new String[Variables.PHAPLUAT_CAPTION.length];
//                addUrl(Variables.PHAPLUAT_ADDRESS, Variables.PHAPLUAT_CAPTION);
//                break;
//            default:
//                break;
//
//        }
//    }
//
//    private void addUrl(String address[], String caption[]) {
//        for (int i = 1; i < address.length; i++) {
//            mUrlAddress[i] = address[i];
//            mUrlCaption[i] = caption[i];
//        }
//    }
//
//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        String mAddressString = mUrlAddress[position];
//        String mCaptionString = mUrlCaption[position];
//
//        Intent intent = new Intent(WebSelected.this, ShowCategory.class);
//        Bundle bd = new Bundle();
//        bd.putString("address", mAddressString);
//        bd.putString("caption", mCaptionString);
//        bd.putSerializable("websiteaddress", websiteAddress);
//        intent.putExtras(bd);
//        startActivity(intent);
//    }
//}
