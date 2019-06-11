package com.example.mohamed.splash.fragmentTabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new CurrentFragmentTab();
            case 1:
                return new InProcessFragmentTab();
            case 2:
                return new ScheduledFragmentTab();
            case 3:
                return new CompletedFragmentTab();
            case 4:
                return new CancledFragmebtTab();

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


        switch (position){
            case 0:
                return "Current";
            case 1:
                return  "InProcess";
            case 2:
                return "Scheduled";
            case 3:
                return  "Completed";
            case 4:
                return "Cancled";
                default:
                    return null;
        }



    }
}
