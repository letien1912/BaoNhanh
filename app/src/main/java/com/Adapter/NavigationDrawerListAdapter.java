package com.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baonhanh.R;
import com.model.LogoWebsiteItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Le on 06-Feb-16.
 */
public class NavigationDrawerListAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<LogoWebsiteItem> arrayList;

    public NavigationDrawerListAdapter(Context mContext, ArrayList<LogoWebsiteItem> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList!=null?arrayList.size():0;
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View childView = null;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            childView = inflater.inflate(R.layout.layout_navigation_listview_adapter,null);

        } else {
            childView = convertView;
        }

        ImageView imageView = (ImageView) childView.findViewById(R.id.navigation_ImageView);
        TextView textView = (TextView) childView.findViewById(R.id.navigationTextView);

        Picasso.with(mContext).load(arrayList.get(position).getImageID())
            .error(R.drawable.placeholder).placeholder(R.drawable.placeholder)
            .into(imageView);
        textView.setText(arrayList.get(position).getNameWebsite());

        return childView;
    }
}
