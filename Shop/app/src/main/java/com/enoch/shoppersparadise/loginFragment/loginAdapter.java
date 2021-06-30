package com.enoch.shoppersparadise.loginFragment;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class loginAdapter extends FragmentPagerAdapter {
    private String[] tabTitles = new String[]{"Login", "Register"};

    private Context context;
    int totaltabs;

    public loginAdapter(@NonNull FragmentManager fm, Context context,int totaltabs) {
        super(fm);
        this.context = context;
        this.totaltabs = totaltabs;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                LoginTabFragment loginTabFragment = new LoginTabFragment();
                return  loginTabFragment;
            case 1:
                SignupTabFragment signupTabFragment = new SignupTabFragment();
                return signupTabFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totaltabs;
    }
}
