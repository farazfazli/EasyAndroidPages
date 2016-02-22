package com.farazfazli.pagesexample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Faraz on 2/21/2016.
 */
public class PageFragment extends Fragment {

    private int mCurrentPage = 0;

    public PageFragment() {
    }

    public static PageFragment create(int page) {
        PageFragment pageFragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt("page", page);
        pageFragment.setArguments(args);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCurrentPage = getArguments().getInt("page", 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        int[] colors = new int[]{Color.RED, Color.GREEN, Color.BLUE};
        String[] pagesText = new String[]{"First page", "Second page", "Third page"};

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.page, container, false);
        RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.relative_layout);
        TextView textView = (TextView) rootView.findViewById(R.id.textView);

        textView.setTextColor(Color.WHITE);

        relativeLayout.setBackgroundColor(colors[mCurrentPage]);
        textView.setText(pagesText[mCurrentPage]);
        return rootView;
    }
}
