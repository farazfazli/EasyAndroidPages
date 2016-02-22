package com.farazfazli.pagesexample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Faraz on 2/21/2016.
 */
public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    private int mNumberOfPages = 3;

    public ScreenSlidePagerAdapter(FragmentManager fm, int numberOfPages) {
        super(fm);
        this.mNumberOfPages = numberOfPages;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return PageFragment.create(0);
            case 1:
                return PageFragment.create(1);
            case 2:
                return PageFragment.create(2);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumberOfPages;
    }
}
