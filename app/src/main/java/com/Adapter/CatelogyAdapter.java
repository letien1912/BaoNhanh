package com.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baonhanh.R;
import com.model.PeriodTimeFromNews;
import com.model.RssItems;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Le on 16-Jan-16.
 */
public class CatelogyAdapter extends RecyclerView.Adapter<CatelogyAdapter.CatelogyViewHolder> {

    private ArrayList<RssItems> rssItemses;
    private Context mContext;

    public CatelogyAdapter(ArrayList<RssItems> rssItemses, Context mContext) {
        this.rssItemses = rssItemses;
        this.mContext = mContext;
    }

    @Override
    public CatelogyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_adapter_catelogy, null);
        return new CatelogyViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(CatelogyViewHolder holder, int position) {
        RssItems items = rssItemses.get(position);
        if (items.getmImageLink() != null) {
            Picasso.with(mContext).load(items.getmImageLink())
                    .error(R.drawable.placeholder).placeholder(R.drawable.placeholder)
                    .into(holder.myImageView);
        } else {
            holder.myImageView.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.placeholder), 120, 80, false));
        }
        holder.myCaptionTextView.setText(items.getmTitle());
        /*Lay Khoang thoi gian tu luc bao dang tin cho toi thoi dien hien thoi*/
        holder.myDescripetionTextView.setText(PeriodTimeFromNews.createDay(items.getmDateTime()));
    }


    @Override
    public int getItemCount() {
        return rssItemses != null ? rssItemses.size() : 0;
    }

    public class CatelogyViewHolder extends RecyclerView.ViewHolder {
        private ImageView myImageView;
        private TextView myCaptionTextView;
        private TextView myDescripetionTextView;

        public CatelogyViewHolder(View itemView) {
            super(itemView);

            myImageView = (ImageView) itemView.findViewById(R.id.catelogyImageView);
            myCaptionTextView = (TextView) itemView.findViewById(R.id.catelogyCaptionTextView);
            myDescripetionTextView = (TextView) itemView.findViewById(R.id.catelogyDescipeTextView);
        }
    }
}
