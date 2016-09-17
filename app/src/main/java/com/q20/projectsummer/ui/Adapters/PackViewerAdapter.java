package com.q20.projectsummer.ui.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.q20.projectsummer.ui.PackFragmentFirst;
import com.q20.projectsummer.ui.PackFragmentSecond;

public class PackViewerAdapter extends FragmentPagerAdapter {

    public PackViewerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) new PackFragmentFirst();
        return new PackFragmentSecond();
    }

    @Override
    public int getCount() {
        return 2;
    }
}
