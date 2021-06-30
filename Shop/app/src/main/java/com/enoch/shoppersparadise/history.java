package com.enoch.shoppersparadise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.enoch.shoppersparadise.DAO.DAO;
import com.enoch.shoppersparadise.PhoneList.BillAdapter;
import com.enoch.shoppersparadise.PhoneList.HisAdapter;
import com.enoch.shoppersparadise.model.Billing;
import com.enoch.shoppersparadise.model.Product;

import java.util.List;

public class history extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE;

        int uiOptions1 = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;

        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(uiOptions);
        decorView.setSystemUiVisibility(uiOptions1);

        setContentView(R.layout.activity_history);
        SharedPreferences prf;
        AppCompatTextView backmain;
        backmain = findViewById(R.id.backtomain);

        prf = getBaseContext().getSharedPreferences("users",getBaseContext().MODE_PRIVATE);
        int id = prf.getInt("UserId",-1);
        recyclerView = findViewById(R.id.rechis);
        DAO db = new DAO(getBaseContext());
        List<Billing> bill = db.getListBill(id);
        HisAdapter padapter = new HisAdapter(bill,getBaseContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(padapter);



        SharedPreferences.Editor editor = prf.edit();
        backmain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}