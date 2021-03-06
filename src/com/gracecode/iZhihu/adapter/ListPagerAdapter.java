package com.gracecode.iZhihu.adapter;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import com.gracecode.iZhihu.fragment.QuestionsListFragment;
import com.gracecode.iZhihu.fragment.StaredListFragment;

import java.util.ArrayList;

public class ListPagerAdapter extends FragmentStatePagerAdapter implements ViewPager.OnPageChangeListener {
    public static final int FIRST_TAB = 0;
    public static final int SECOND_TAB = 1;

    private final ActionBar actionBar;
    private final static ArrayList<Fragment> mFragments = new ArrayList<Fragment>();

    public ListPagerAdapter(Activity activity) {
        super(activity.getFragmentManager());
        actionBar = activity.getActionBar();

        mFragments.add(FIRST_TAB, new QuestionsListFragment());
//        fragment.add(FIRST_TAB, new QuestionsGridFragment());
        mFragments.add(SECOND_TAB, new StaredListFragment());
    }

    public Fragment getBaseListFragment(int index) {
        return mFragments.get(index);
//        switch (index) {
//            case SECOND_TAB:
//                return new StaredListFragment();
//
//            default:
//                return new QuestionsListFragment();
//        }
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, 0, object);
    }

    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public void onPageScrolled(int i, float v, int i2) {
        // ...
    }

    @Override
    public void onPageSelected(int i) {
        switch (i) {
            case FIRST_TAB:
            case SECOND_TAB:
                actionBar.setSelectedNavigationItem(i);
        }
    }

    @Override
    public void notifyDataSetChanged() {
        try {
            super.notifyDataSetChanged();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {
        // ...

    }
}
