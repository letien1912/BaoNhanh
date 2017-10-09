package com.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baonhanh.R;

/**
 * Created by Le on 15-Jan-16.
 */
public class ViewHolderSelectIcon extends RecyclerView.ViewHolder{
    protected ImageView myImageViewHolder;
    protected TextView myImageViewText;

    public ViewHolderSelectIcon(View itemView) {
        super(itemView);
        myImageViewHolder = (ImageView) itemView.findViewById(R.id.thumbnail_img);
        myImageViewText = (TextView) itemView.findViewById(R.id.thumbnail_text);
    }

}
