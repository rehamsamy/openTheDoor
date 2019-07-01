package com.openthedoor.fragmentTabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new CurrentFragmentTab();
                return fragment;
            case 1:
                fragment = new InProcessFragmentTab();
                return fragment;
            case 2:
                fragment = new ScheduledFragmentTab();
                return fragment;
            case 3:
                fragment = new CancledFragmebtTab();
                return fragment;
            case 4:
                fragment = new CompletedFragmentTab();
                return fragment;

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Current";
            case 1:
                return "InProcess";
            case 2:
                return "Scheduled";
            case 3:
                return "Canceled";
            case 4:
                return "Completed";
            default:
                return null;
        }


    }
}
