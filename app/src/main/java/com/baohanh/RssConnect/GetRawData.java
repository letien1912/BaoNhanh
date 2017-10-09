package com.baohanh.RssConnect;

import android.os.AsyncTask;
import android.util.Log;

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

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class GetRawData {
    private String LOG_TAG = GetRawData.class.getSimpleName();
    private NodeList mNodeList;
    private String mUrl;

    public GetRawData(String mUrl) {
        this.mUrl = mUrl;
    }

    public void execute(){
        DownloadData downloadData = new DownloadData();
        downloadData.execute(mUrl);
    }


    public String getmUrl() {
        return mUrl;
    }


    public class DownloadData extends AsyncTask<String, Void, NodeList> {

        @Override
        protected NodeList doInBackground(String... params) {


            try {
                URL mUrl = new URL(params[0]);
                URLConnection mConnection;
                        mConnection = mUrl.openConnection();
                HttpURLConnection mHttpURLConnection = (HttpURLConnection) mConnection;
                int responseCode = mHttpURLConnection.getResponseCode();

                if(responseCode == HttpURLConnection.HTTP_OK){
                    InputStream is = mHttpURLConnection.getInputStream();
                    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                    DocumentBuilder db = dbf.newDocumentBuilder();
                    Document document = db.parse(is);
                    Element treeElement = document.getDocumentElement();
                    NodeList itemsNode = treeElement.getElementsByTagName("item");
                    mNodeList = itemsNode;
                    return itemsNode;
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
        protected void onPostExecute(NodeList s) {
            super.onPostExecute(s);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
}
