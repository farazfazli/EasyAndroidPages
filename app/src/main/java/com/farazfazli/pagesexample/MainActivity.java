package com.farazfazli.pagesexample;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private static final int NUMBER_OF_PAGES = 3;

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    private static final String TAG = "[" + MainActivity.class.getCanonicalName() + "]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(), NUMBER_OF_PAGES);
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.i(TAG, position + "");
                refreshOptionsMenu();
            }

            @Override
            public void onPageSelected(int position) {
                Log.i(TAG, position + "");
                refreshOptionsMenu();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }

        });

        mPager.setAdapter(mPagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main, menu);
        menu.findItem(R.id.action_previous).setEnabled(mPager.getCurrentItem() > 0);

        if (mPager.getCurrentItem() == 2) {
            menu.findItem(R.id.action_next).setTitle("Done");
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_previous:
                Log.i(TAG, "Previous");
                mPager.setCurrentItem(mPager.getCurrentItem() - 1);
                refreshOptionsMenu();
                return true;
            case R.id.action_next:
                Log.i(TAG, "Next");
                mPager.setCurrentItem(mPager.getCurrentItem() + 1);
                refreshOptionsMenu();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void refreshOptionsMenu() {
        invalidateOptionsMenu();
    }

}
