package com.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baonhanh.R;
import com.model.LogoWebsiteItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Le on 15-Jan-16.
 */
public class CardAdapterSelectIcon extends RecyclerView.Adapter<ViewHolderSelectIcon>{

    private ArrayList<LogoWebsiteItem> myWebItems;
    private Context mContext;

    public CardAdapterSelectIcon(ArrayList<LogoWebsiteItem> myWebItems, Context mContext) {
        this.myWebItems = myWebItems;
        this.mContext = mContext;
    }

    @Override
    public ViewHolderSelectIcon onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_card_item, null);
        ViewHolderSelectIcon viewHolderSelectIcon = new ViewHolderSelectIcon(v);
        return viewHolderSelectIcon;
    }

    @Override
    public void onBindViewHolder(ViewHolderSelectIcon holder, int position) {
        LogoWebsiteItem item = myWebItems.get(position);

        /*set image bitmap*/
//        Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), item.getImageID());
//        bitmap.createScaledBitmap(bitmap,options.outWidth,options.outHeight,true);
        Picasso.with(mContext).load(item.getImageID()).error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder).fit().centerInside().into(holder.myImageViewHolder);
        holder.myImageViewText.setText(item.getNameWebsite());
        /**********NOTE: .fit().centerinside() need to view ez more*/

//        holder.myImageViewHolder.setImageBitmap(Bitmap.createScaledBitmap(bitmap,240,240,false));
//        holder.myImageViewHolder.setImageResource(item.getImageID());
    }

    @Override
    public int getItemCount() {
        return myWebItems.size();
    }

}
