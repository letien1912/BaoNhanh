package com.Adapter;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baonhanh.R;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


/**
 * Created by Le on 22-Jan-16.
 */
public class WebSelectedAdapterCardView extends RecyclerView.Adapter<ViewHolderSelectIcon> {

    private static final String RSS_DESCRIPTION = "description";
    private static final String LOG_TAG = WebSelectedAdapterCardView.class.getSimpleName();
    private static final int BALANCE_INDEX_OF_END = 4;
    private static final int BALANCE_INDEX_OF_START = 5;
    private static final int BALANCE_INDEX_OF_ZERO = 0;

    private String[] myUrlCaption;
    private String[] myUrlAddress;
    private Context mcContext;
    private ArrayList<String> resArrays;

    public WebSelectedAdapterCardView(String[] myUrlCaption, String[] myUrlAddress, Context mcContext) {
        this.myUrlCaption = myUrlCaption;
        this.myUrlAddress = myUrlAddress;
        this.mcContext = mcContext;
//        getResArrays();
    }

    @Override
    public ViewHolderSelectIcon onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_card_item, null);
        return new ViewHolderSelectIcon(childView);
    }

    public void getResArrays(){
        for(int i = 0 ; i < myUrlAddress.length; i++)
            new DownloadImageData().execute(myUrlAddress[i]);
    }


    @Override
    public void onBindViewHolder(final ViewHolderSelectIcon holder, final int position) {
//        resArrays = new ArrayList<>();
//        holder.myImageViewText.setText(myUrlCaption[position]);
//
//
//        Picasso.with(mcContext).load(resArrays.get(position)).error(R.drawable.placeholder)
//                .placeholder(R.drawable.placeholder).into(holder.myImageViewHolder);


//        GetRssData getImgData = new GetRssData(myUrlAddress[position], mcContext, null, new OnTaskCompleted() {
//            @Override
//            public void onTaskCompleted(ArrayList<RssItems> list) {
////                RssItems items = list.get(position);
////                Log.d(WebSelectedAdapterCardView.class.getSimpleName(),items.getmImageLink());
////                Picasso.with(mcContext).load(items.getmImageLink()).error(R.drawable.placeholder)
////                        .placeholder(R.drawable.placeholder).into(holder.myImageViewHolder);
//            }
//        });
//        getImgData.execute();
    }

    @Override
    public int getItemCount() {
        return myUrlCaption != null ? myUrlCaption.length : 0;
    }

    /*LAY HINH ANH TU RAW DATA*/
    public void processResult(NodeList nodeList) {
        if (nodeList != null && nodeList.getLength() > 0) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element entry = (Element) nodeList.item(i);
                Element des = (Element) entry.getElementsByTagName(RSS_DESCRIPTION).item(0);
                String desValue = des.getFirstChild().getNodeValue();

                String src;
                if (desValue.length() > BALANCE_INDEX_OF_ZERO) {
                    int start = desValue.indexOf("src=\"") + BALANCE_INDEX_OF_START;
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
                    resArrays.add(src);
                }

            }
        }
    }

    private class DownloadImageData extends AsyncTask<String, Void, NodeList> {

        @Override
        protected NodeList doInBackground(String... params) {
            try {
                URL mUrl = new URL(params[0]);
                URLConnection mConnection;
                mConnection = mUrl.openConnection();
                HttpURLConnection mHttpURLConnection = (HttpURLConnection) mConnection;
                int responseCode = mHttpURLConnection.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    InputStream is = mHttpURLConnection.getInputStream();
                    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                    DocumentBuilder db = dbf.newDocumentBuilder();
                    Document document = db.parse(is);
                    Element treeElement = document.getDocumentElement();
                    return treeElement.getElementsByTagName("item");
                }

            } catch (MalformedURLException e) {
                Log.d(LOG_TAG, "Can loadind URL");
                e.printStackTrace();
            } catch (IOException e) {
                Log.d(LOG_TAG, "Can connect to networth");
                e.printStackTrace();
            } catch (ParserConfigurationException e) {
                Log.d(LOG_TAG, "cant build document");
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(NodeList nodeList) {
            processResult(nodeList);
            super.onPostExecute(nodeList);
        }
    }
}
