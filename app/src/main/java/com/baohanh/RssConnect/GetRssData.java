package com.baohanh.RssConnect;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import com.github.rahatarmanahmed.cpv.CircularProgressView;
import com.model.OnTaskCompleted;
import com.model.RssItems;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

/**
 * Created by Le on 09-Jan-16.
 */


public class GetRssData extends GetRawData {

    private String LOG_TAG = GetRssData.class.getSimpleName();

    private ArrayList<RssItems> mListRssItems;
    private OnTaskCompleted onTaskCompleted;

    private static final String RSS_TITLE = "title";
    private static final String RSS_DESCRIPTION = "description";
    private static final String RSS_PUBDATE = "pubDate";
    private static final String RSS_LINK = "link";

    private static final int BALANCE_INDEX_OF_END = 4;
    private static final int BALANCE_INDEX_OF_START = 5;
    private static final int BALANCE_INDEX_OF_ZERO = 0;
    private Context mContext;
    private CircularProgressView progressView;

    public GetRssData(String mUrl, Context mContext, CircularProgressView progressView, OnTaskCompleted onTaskCompleted) {
        super(mUrl);
        this.progressView = progressView;
        this.mContext = mContext;
        this.onTaskCompleted = onTaskCompleted;
        mListRssItems = new ArrayList<>();
    }


    @Override
    public void execute() {
        super.execute();
        DownloadRSSData downloadRSSData = new DownloadRSSData();
        downloadRSSData.execute(getmUrl());
    }

    public void processResult(NodeList nodeList) {
        if (nodeList != null && nodeList.getLength() > 0) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element entry = (Element) nodeList.item(i);

                Element title = (Element) entry.getElementsByTagName(RSS_TITLE).item(0);
                Element des = (Element) entry.getElementsByTagName(RSS_DESCRIPTION).item(0);
                Element pubdate = (Element) entry.getElementsByTagName(RSS_PUBDATE).item(0);
                Element link = (Element) entry.getElementsByTagName(RSS_LINK).item(0);

                if (title == null || des == null || pubdate == null || link == null)
                    continue;

                String titleValue = getNodeValue_(title);
                String desValue = getNodeValue_(des);
                String pubdateValue = getNodeValue_(pubdate);
                String linkValue = getNodeValue_(link);

                String src = null;
                if (desValue.length() > BALANCE_INDEX_OF_ZERO) {
                    int start = desValue.indexOf("src=") + BALANCE_INDEX_OF_START;
                    int end = desValue.indexOf(".jpg", start) + BALANCE_INDEX_OF_END;
                    int end2 = desValue.indexOf(".png", start) + BALANCE_INDEX_OF_END;
                    Log.d(LOG_TAG, start + " " + end + " " + end2);

                    if (end - BALANCE_INDEX_OF_END > BALANCE_INDEX_OF_ZERO) {
                        if (start < BALANCE_INDEX_OF_ZERO || start >= end) {
                            src = null;
                        } else {
                            src = desValue.substring(start, end);
                        }
                    } else if (end2 - BALANCE_INDEX_OF_END > BALANCE_INDEX_OF_ZERO) {
                        if (start < BALANCE_INDEX_OF_ZERO || start >= end2) {
                            src = null;
                        } else {
                            src = desValue.substring(start, end2);
                        }
                    } else {
                        src = null;
                    }

                    String x = "quot;";
                    if (src != null)
                        if (src.contains("quot;")) {
                            src = src.replaceAll(x,"");
                            Log.d("----------------", src == null ? "" : src);
                        }
                }

                RssItems rssItems = new RssItems(titleValue, desValue, linkValue, pubdateValue, src);
                mListRssItems.add(rssItems);
                Log.d(LOG_TAG, rssItems.toString());
            }
        }
    }

    public String getNodeValue_(Element e) {
        if (e.getFirstChild().getNodeValue() == null)
            return " ";
        return e.getFirstChild().getNodeValue();
    }

    private class DownloadRSSData extends DownloadData {
        @Override
        protected void onPreExecute() {
            ObjectAnimator animator = ObjectAnimator.ofInt(progressView, "progress", 0, 200);
            animator.setInterpolator(new DecelerateInterpolator());
            if (progressView != null) {
                animator.start();
                progressView.setVisibility(View.VISIBLE);
                progressView.startAnimation();
            }
            super.onPreExecute();
        }

        @Override
        protected NodeList doInBackground(String... params) {
            return super.doInBackground(params);
        }

        @Override
        protected void onPostExecute(NodeList s) {
            super.onPostExecute(s);
            progressView.clearAnimation();
            if (progressView != null)
                progressView.setVisibility(View.GONE);
            processResult(s);
            onTaskCompleted.onTaskCompleted(mListRssItems);
        }
    }
}
