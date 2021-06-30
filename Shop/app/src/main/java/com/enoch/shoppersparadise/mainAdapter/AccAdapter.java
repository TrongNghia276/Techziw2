package com.enoch.shoppersparadise.mainAdapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.enoch.shoppersparadise.R;
import com.enoch.shoppersparadise.loginFragment.LoginTabFragment;
import com.enoch.shoppersparadise.loginFragment.SignupTabFragment;

public class AccAdapter  extends FragmentPagerAdapter {

    private Context context;
    int totaltabs;
    public AccAdapter(@NonNull FragmentManager fm, Context context,int totaltabs) {
        super(fm);
        this.context = context;
        this.totaltabs = totaltabs;
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        AccPage accPage = new AccPage();
        return accPage;
    }

    @Override
    public int getCount() {
        return totaltabs;
    }
}
