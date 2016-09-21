package com.q20.projectsummer.ui.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.q20.projectsummer.ui.FirstProfileImageFragment;
import com.q20.projectsummer.ui.SecondProfileImageFragment;

/**
 * Created by mohammadmahdi on 9/21/16.
 */
public class ProfileImageFragmentAdapter extends FragmentPagerAdapter {
    public ProfileImageFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new FirstProfileImageFragment();
        }else {
            return new SecondProfileImageFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
