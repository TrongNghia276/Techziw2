package com.enoch.shoppersparadise.mainAdapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class mainAdapter  extends FragmentPagerAdapter {

    private Context context;
    int totaltabs;
    public mainAdapter(@NonNull FragmentManager fm, Context context,int totaltabs) {
        super(fm);
        this.context = context;
        this.totaltabs = totaltabs;
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                ShopPage shopPage = new ShopPage();
                return shopPage;

            case 1:
                dashBoardTabFragment dashBoardTabFragment = new dashBoardTabFragment();
                return  dashBoardTabFragment;

            case 2:
                CartPage messPage = new CartPage();
                return messPage;
            case 3:
                AccTabFragment accTabFragment = new AccTabFragment();
                return accTabFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totaltabs;
    }

}
