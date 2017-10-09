package com.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Le on 15-Jan-16.
 */
public class RecyclerViewOnClickListener implements RecyclerView.OnItemTouchListener {


    public interface OnItemClickListener {

        void onItemClick(View v, int pos);

        void onItemLongClick(View v, int pos);

    }

    private OnItemClickListener onItemClickListener;
    private GestureDetector gestureDetector;

    public RecyclerViewOnClickListener(Context context, final RecyclerView recyclerView, final OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
//                View v = recyclerView.findChildViewUnder(e.getX(), e.getY());
//                Log.d("DDDDDDDDDDDDDDDDDDD", e.getX() +"-"+ e.getY());
//                if (v != null && onItemClickListener != null)
//                    onItemClickListener.onItemClick(v, recyclerView.getChildAdapterPosition(v));
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                View v = recyclerView.findChildViewUnder(e.getX(), e.getY());
                Log.d("Long press", e.getX() +"-"+ e.getY());
                if (v != null && onItemClickListener != null)
                    onItemClickListener.onItemClick(v, recyclerView.getChildAdapterPosition(v));
            }
        });

    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View v = rv.findChildViewUnder(e.getX(), e.getY());

        if (v != null && onItemClickListener != null && gestureDetector.onTouchEvent(e))
            onItemClickListener.onItemClick(v, rv.getChildAdapterPosition(v));
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

}
