package com.enoch.shoppersparadise.mainAdapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CartAdapter extends FragmentPagerAdapter {

    private Context context;
    int totaltabs;
    public CartAdapter(@NonNull FragmentManager fm, Context context, int totaltabs) {
        super(fm);
        this.context = context;
        this.totaltabs = totaltabs;
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        CartPage accPage = new CartPage();
        return accPage;
    }

    @Override
    public int getCount() {
        return totaltabs;
    }
}
