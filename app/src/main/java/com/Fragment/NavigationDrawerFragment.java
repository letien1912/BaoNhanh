package com.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baonhanh.R;

/**
 * Created by Le on 17-Jan-16.
 */
public class NavigationDrawerFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View childView = inflater.inflate(R.layout.content_fragment,container,false);
        return childView;
    }
}
