package com.enoch.shoppersparadise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.enoch.shoppersparadise.loginFragment.loginAdapter;
import com.enoch.shoppersparadise.mainAdapter.mainAdapter;
import com.google.android.material.tabs.TabLayout;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.enoch.shoppersparadise.R.drawable.ic_acc;
import static com.enoch.shoppersparadise.R.drawable.ic_acc_noactive;
import static com.enoch.shoppersparadise.R.drawable.ic_dash;
import static com.enoch.shoppersparadise.R.drawable.ic_dash_active;
import static com.enoch.shoppersparadise.R.drawable.ic_store;
import static com.enoch.shoppersparadise.R.drawable.ic_store_active;

public class MainActivity extends AppCompatActivity {

    private  int accActive = R.drawable.ic_acc;
    private AppCompatImageView Home,imgAcc,imgDash,imgChat,hoticon;
    private TextView textHome,textAcc,textDash,textChat;
    private  int acc = R.drawable.ic_acc_noactive;
    private ViewPager viewPager;

    LinearLayoutCompat loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        setContentView(R.layout.activity_main);
        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE;

        int uiOptions1 = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;

        decorView.setSystemUiVisibility(uiOptions);
        decorView.setSystemUiVisibility(uiOptions1);

        Home = findViewById(R.id.dasha);
        imgAcc = findViewById(R.id.accounticon);
        textAcc = findViewById(R.id.TextAcc);
        textHome = findViewById(R.id.textdasha);

        viewPager = findViewById(R.id.view_paper_main);

        mainAdapter adapter10 = new mainAdapter(getSupportFragmentManager(),getBaseContext(),4);
        viewPager.setAdapter(adapter10);
        viewPager.setCurrentItem(1);
        imgChat = findViewById(R.id.dashchat);
        imgDash = findViewById(R.id.dashb);
        textChat = findViewById(R.id.textdashchat);
        textDash = findViewById(R.id.textdashb);
        viewPager = findViewById(R.id.view_paper_main);
        hoticon = findViewById(R.id.hoticon);
        loading = findViewById(R.id.loading);
         SharedPreferences prf;

        prf = getBaseContext().getSharedPreferences("users",getBaseContext().MODE_PRIVATE);
        int main = prf.getInt("main",-1);

        SharedPreferences.Editor editor = prf.edit();
        if (main == 3){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            loading.setVisibility(View.VISIBLE);
            imgDash.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), ic_store));
            imgChat.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), R.drawable.ic_chaat_active));
            Home.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), ic_dash));
            imgAcc.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), ic_acc_noactive));
            textHome.setTextColor(getResources().getColor(R.color.gray_700));
            textAcc.setTextColor(getResources().getColor(R.color.gray_700));
            textChat.setTextColor(getResources().getColor(R.color.O_700));
            textDash.setTextColor(getResources().getColor(R.color.gray_700));
            viewPager = findViewById(R.id.view_paper_main);

            mainAdapter adapter = new mainAdapter(getSupportFragmentManager(),getBaseContext(),4);
            viewPager.setAdapter(adapter);
            viewPager.setCurrentItem(2);
            editor.putInt("main",1);
            editor.commit();
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);


            loading.setVisibility(View.GONE);
        }else if(main==1){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            loading.setVisibility(View.VISIBLE);
            imgDash.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), ic_store));
            imgChat.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), R.drawable.ic_chat));
            Home.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), ic_dash_active));
            imgAcc.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), ic_acc_noactive));
            textHome.setTextColor(getResources().getColor(R.color.O_700));
            textAcc.setTextColor(getResources().getColor(R.color.gray_700));
            textChat.setTextColor(getResources().getColor(R.color.gray_700));
            textDash.setTextColor(getResources().getColor(R.color.gray_700));
            viewPager = findViewById(R.id.view_paper_main);

            mainAdapter adapter = new mainAdapter(getSupportFragmentManager(),getBaseContext(),4);
            viewPager.setAdapter(adapter);
            viewPager.setCurrentItem(1);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);


            loading.setVisibility(View.GONE);

        }else if(main==0){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            loading.setVisibility(View.VISIBLE);
            imgDash.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), ic_store));
            imgChat.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), R.drawable.ic_chat));
            Home.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), ic_dash_active));
            imgAcc.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), ic_acc_noactive));
            textHome.setTextColor(getResources().getColor(R.color.O_700));
            textAcc.setTextColor(getResources().getColor(R.color.gray_700));
            textChat.setTextColor(getResources().getColor(R.color.gray_700));
            textDash.setTextColor(getResources().getColor(R.color.gray_700));
            viewPager = findViewById(R.id.view_paper_main);

            mainAdapter adapter = new mainAdapter(getSupportFragmentManager(),getBaseContext(),4);
            viewPager.setAdapter(adapter);
            viewPager.setCurrentItem(0);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            editor.putInt("main",1);
            editor.commit();

            loading.setVisibility(View.GONE);

        }else if(main==2){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            loading.setVisibility(View.VISIBLE);
            imgDash.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), ic_store));
            imgChat.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), R.drawable.ic_chaat_active));
            Home.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), ic_dash));
            imgAcc.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), ic_acc_noactive));
            textHome.setTextColor(getResources().getColor(R.color.gray_700));
            textAcc.setTextColor(getResources().getColor(R.color.gray_700));
            textChat.setTextColor(getResources().getColor(R.color.O_700));
            textDash.setTextColor(getResources().getColor(R.color.gray_700));
            viewPager = findViewById(R.id.view_paper_main);

            mainAdapter adapter = new mainAdapter(getSupportFragmentManager(),getBaseContext(),4);
            viewPager.setAdapter(adapter);
            viewPager.setCurrentItem(2);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            editor.putInt("main",1);
            editor.commit();

            loading.setVisibility(View.GONE);

        }else{
            viewPager.setCurrentItem(1);
        }

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                loading.setVisibility(View.VISIBLE);
                imgDash.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), ic_store));
                imgChat.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), R.drawable.ic_chat));
                Home.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), ic_dash_active));
                imgAcc.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), ic_acc_noactive));
                textHome.setTextColor(getResources().getColor(R.color.O_700));
                textAcc.setTextColor(getResources().getColor(R.color.gray_700));
                textChat.setTextColor(getResources().getColor(R.color.gray_700));
                textDash.setTextColor(getResources().getColor(R.color.gray_700));
                viewPager = findViewById(R.id.view_paper_main);

                 mainAdapter adapter = new mainAdapter(getSupportFragmentManager(),getBaseContext(),4);
                viewPager.setAdapter(adapter);
                viewPager.setCurrentItem(1);
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);


                loading.setVisibility(View.GONE);
            }
        });
        imgAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                loading.setVisibility(View.VISIBLE);
                imgDash.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), ic_store));
                imgChat.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), R.drawable.ic_chaat));
                Home.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), ic_dash));
                imgAcc.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), ic_acc));
                textHome.setTextColor(getResources().getColor(R.color.gray_700));
                textAcc.setTextColor(getResources().getColor(R.color.O_700));
                textChat.setTextColor(getResources().getColor(R.color.gray_700));
                textDash.setTextColor(getResources().getColor(R.color.gray_700));
                viewPager = findViewById(R.id.view_paper_main);

                 mainAdapter adapter = new mainAdapter(getSupportFragmentManager(),getBaseContext(),4);
                viewPager.setAdapter(adapter);
                viewPager.setCurrentItem(3);
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);


                loading.setVisibility(View.GONE);
            }
        });
        hoticon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getBaseContext(), Banner.class));
            }
        });
        imgDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                loading.setVisibility(View.VISIBLE);
                imgDash.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), ic_store_active));
                imgChat.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), R.drawable.ic_chat));
                Home.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), ic_dash));
                imgAcc.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), ic_acc_noactive));
                textHome.setTextColor(getResources().getColor(R.color.gray_700));
                textAcc.setTextColor(getResources().getColor(R.color.gray_700));
                textChat.setTextColor(getResources().getColor(R.color.gray_700));
                textDash.setTextColor(getResources().getColor(R.color.O_700));
                viewPager = findViewById(R.id.view_paper_main);

                 mainAdapter adapter = new mainAdapter(getSupportFragmentManager(),getBaseContext(),4);
                viewPager.setAdapter(adapter);
                viewPager.setCurrentItem(0);
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);


                loading.setVisibility(View.GONE);
            }
        });
        imgChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                loading.setVisibility(View.VISIBLE);
                imgDash.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), ic_store));
                imgChat.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), R.drawable.ic_chaat_active));
                Home.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), ic_dash));
                imgAcc.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), ic_acc_noactive));
                textHome.setTextColor(getResources().getColor(R.color.gray_700));
                textAcc.setTextColor(getResources().getColor(R.color.gray_700));
                textChat.setTextColor(getResources().getColor(R.color.O_700));
                textDash.setTextColor(getResources().getColor(R.color.gray_700));
                viewPager = findViewById(R.id.view_paper_main);

                 mainAdapter adapter = new mainAdapter(getSupportFragmentManager(),getBaseContext(),4);
                viewPager.setAdapter(adapter);
                viewPager.setCurrentItem(2);
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);


                loading.setVisibility(View.GONE);
            }
        });


    }




}