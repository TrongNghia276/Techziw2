package com.enoch.shoppersparadise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.enoch.shoppersparadise.DAO.DAO;
import com.enoch.shoppersparadise.model.Address;

public class address extends AppCompatActivity {


    AppCompatEditText Line1;
    AppCompatEditText Line2;
    AppCompatEditText Phone;
    AppCompatEditText City;
    AppCompatEditText Zipcode;
    AppCompatEditText State;
    AppCompatEditText Country;
    AppCompatButton Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        Line1 = findViewById(R.id.line1);
        Line2 = findViewById(R.id.line2);
        Phone = findViewById(R.id.phone);
        City = findViewById(R.id.City);
        Zipcode = findViewById(R.id.zip);
        State = findViewById(R.id.state);
        Country = findViewById(R.id.country);
        Button = findViewById(R.id.createadd);

        Button.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                DAO db = new DAO(getBaseContext());
                SharedPreferences prf;
                prf = getBaseContext().getSharedPreferences("users",getBaseContext().MODE_PRIVATE);
                int id = prf.getInt("UserId",-1);
                Address address = new Address();

                address.setUserId(id);
                address.setLine1(Line1.getText().toString());

                address.setLine2(Line2.getText().toString());
                address.setPhone(Phone.getText().toString());
                address.setCity(City.getText().toString());
                address.setZipcode(Zipcode.getText().toString());
                address.setState(State.getText().toString());
                address.setCountry(Country.getText().toString());
                db.addAddress(address);
                startActivity(new Intent(address.this, AddressList.class));
            }
        });
    }
}