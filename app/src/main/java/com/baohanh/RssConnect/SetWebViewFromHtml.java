package com.baohanh.RssConnect;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.webkit.WebView;

import com.baonhanh.R;
import com.model.Variables;
import com.model.WebsiteAddress;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by Le on 13-Jan-16.
 */
public class SetWebViewFromHtml {

    private WebView myWebView;
    private String myLinkHtml;
    private WebsiteAddress websiteAddress;
    private static String CANT_LOAD_CONTENT = "";

    public SetWebViewFromHtml(WebView myWebView, String myLinkHtml, WebsiteAddress websiteAddress, Context mContext) {
        this.myWebView = myWebView;
        this.myLinkHtml = myLinkHtml;
        this.websiteAddress = websiteAddress;
        CANT_LOAD_CONTENT = mContext.getString(R.string.cant_load_content);
    }

    public void execute() {
        DownLoadHtlmData downLoadHtlmData = new DownLoadHtlmData();
        downLoadHtlmData.execute();
    }

    private class DownLoadHtlmData extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            try {
                String htmlString = "";
                Document doc = Jsoup.connect(myLinkHtml).get();
                Elements element = null;
                switch (websiteAddress) {
                    case VNEXPRESS:
                        return getHtmlString(Variables.VNEXPRESS_HTLMJSOUP, doc);
                    case _24H:
                        element = doc.select(Variables._24H_HTLMHSOUP[0]);
                        doc.select(Variables._24H_HTLMHSOUP[1]).remove();
                        doc.select(Variables._24H_HTLMHSOUP[2]).remove();
                        for (int i = 0; i < element.size(); i++) {
                            htmlString += element.get(i).html();
                        }
                        break;

                    case LAODONG:
                        return getHtmlString(Variables.LAODONG_HTMLJSOUP, doc);
                    case PHAPLUAT:
                        return getHtmlString(Variables.PHAPLUAT_HTMLJSOUP, doc);
                    case TUOITRE:
                        return getHtmlString(Variables.TUOITRE_HTMLJSOUP, doc);
                    case THANHNIEN:
                        String mainPage = getHtmlString(Variables.THANHNIEN_HTMLJSOUP, doc);
                        return mainPage != CANT_LOAD_CONTENT   ? mainPage : getHtmlString(Variables.THANHNIEN_HTMLJSOUP_THETHAO, doc);
                    case TINHTE:
                        return getHtmlString(Variables.TINHTE_HTMLJSOUP, doc);
                    default:
                        break;
                }
                return htmlString;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        public String getHtmlString(String[] webName, Document doc) {
            String htmlString = CANT_LOAD_CONTENT ;
            Log.d("asdasdasd222",doc.toString() + "fuckfuckfuck");
            Elements element = doc.select(webName[0]);
            Log.d("asdasdasd",element.toString() + "fuckfuckfuck");
            for (int i = 1; i < webName.length; i++)
                doc.select(webName[i]).remove();

            for (int i = 0; i < element.size(); i++)
                htmlString += element.get(i).html();

            if(htmlString.compareTo(CANT_LOAD_CONTENT) == 0)
                return htmlString;
            return htmlString.replace(CANT_LOAD_CONTENT,"");
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            String myHtmlString = s.replace("<img", "<img height=\"auto\" width=\"100%\" ");
            myWebView.loadData(myHtmlString, "text/html; charset=UTF-8", null);
        }
    }
}
