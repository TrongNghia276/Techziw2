package com.enoch.shoppersparadise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.enoch.shoppersparadise.DAO.DAO;
import com.enoch.shoppersparadise.PhoneList.AddressListAdapter;
import com.enoch.shoppersparadise.PhoneList.PhoneAdapter;
import com.enoch.shoppersparadise.model.Address;
import com.enoch.shoppersparadise.model.Product;

import java.util.List;

public class AddressList extends AppCompatActivity {


    AppCompatEditText Line1;
    AppCompatEditText Line2;
    AppCompatEditText Phone;
    AppCompatEditText City;
    AppCompatEditText Zipcode;
    AppCompatEditText State;
    AppCompatEditText Country;
    AppCompatTextView Button;
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

        setContentView(R.layout.listadress);
        AppCompatTextView backtomaina;
        backtomaina = findViewById(R.id.backtomaina);

    recyclerView = findViewById(R.id.listaddressc);
        SharedPreferences prf;
        prf = getBaseContext().getSharedPreferences("users",getBaseContext().MODE_PRIVATE);
        int id = prf.getInt("UserId",-1);
        DAO db = new DAO(getBaseContext());
        List<Address> address = db.getListAddress(id);
        Button = findViewById(R.id.createadd);
        
        AddressListAdapter padapter = new AddressListAdapter(address,getBaseContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(padapter);
        Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), address.class));
            }
        });
        backtomaina.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}