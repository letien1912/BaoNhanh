package com.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.baonhanh.R;

public class PageFragmentPaperAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 2;
    private String tabTitles[];
    private Context context;
    private Bundle fragmentBundle;

    public PageFragmentPaperAdapter(FragmentManager fm, Context context, Bundle fragmentBundle) {
        super(fm);
        this.context = context;
        this.fragmentBundle = fragmentBundle;
        tabTitles = context.getResources().getStringArray(R.array.titleNewsArray);
        Log.d("2213213213", fragmentBundle.toString());
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    public void setFragmentBundle(Bundle fragmentBundle) {
        this.fragmentBundle = fragmentBundle;
    }

    public Bundle getFragmentBundle() {
        return fragmentBundle;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ShowMainNewsFragment().newInstance(getFragmentBundle());
            case 1:
                return new WebSelectedFragment().newInstance(getFragmentBundle());
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    public void update(Bundle bd){
        fragmentBundle = bd;
    }


}
