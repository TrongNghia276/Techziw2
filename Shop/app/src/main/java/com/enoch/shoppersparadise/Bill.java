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
import android.widget.RadioButton;
import android.widget.TextView;

import com.enoch.shoppersparadise.DAO.DAO;
import com.enoch.shoppersparadise.PhoneList.AddressListAdapter;
import com.enoch.shoppersparadise.PhoneList.BillAdapter;
import com.enoch.shoppersparadise.model.Address;
import com.enoch.shoppersparadise.model.Billing;
import com.enoch.shoppersparadise.model.Cart;
import com.enoch.shoppersparadise.model.Product;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Bill extends AppCompatActivity {

    AppCompatTextView Button;
    RecyclerView recyclerView;
    TextView phonebill,line1,line2,quantity,pricebill,fullname,date1,checkout,backcart;
    RadioButton radioButton;
    int priceta = 0;
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
        setContentView(R.layout.activity_bill);

        recyclerView = findViewById(R.id.recbill);
        SharedPreferences prf;
        prf = getBaseContext().getSharedPreferences("users",getBaseContext().MODE_PRIVATE);
        int id = prf.getInt("UserId",-1);
        DAO db = new DAO(getBaseContext());
        List<Cart> cart = db.getListCart(id);
        checkout = findViewById(R.id.btncheck);

        List<Product> product = db.getAllProduct();
        BillAdapter padapter = new BillAdapter(cart,product,getBaseContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(padapter);

        backcart = findViewById(R.id.backtocart);
        fullname = findViewById(R.id.fullnamebill);
        date1 = findViewById(R.id.date1);
        quantity = findViewById(R.id.quantitybill);
        pricebill = findViewById(R.id.pricebill);
        phonebill = findViewById(R.id.phonebill);
        line1 = findViewById(R.id.linebill1);
        line2 = findViewById(R.id.linebill2);
        if(prf.getString("phone","-1").equals("-1")){
            phonebill.setVisibility(View.GONE);
            line1.setVisibility(View.GONE);
            line2.setVisibility(View.GONE);

        }else{
            phonebill.setVisibility(View.VISIBLE);
            line1.setVisibility(View.VISIBLE);
            line2.setVisibility(View.VISIBLE);
            phonebill.setText("Phone: "+prf.getString("phone","-1"));
            line1.setText(prf.getString("line1",""));
            line2.setText(prf.getString("line2",""));
        }
        String name = prf.getString("UserFullName","");
        fullname.setText("FullName: "+name);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        date1.setText("Date of purchase: "+ formatter.format(date));
        List<Cart> cart1 = db.getListCart(id);
        List<Product> products = db.getAllProduct();

        int quantity1 = 0;
        for(Product pro: products){
            for(Cart c : cart1){
                if(pro.getProductId() == c.getProductId()){
                    quantity1 = quantity1 + c.getQuantity();
                    priceta = priceta +pro.getPrice()*c.getQuantity();
                    pricebill.setText("$"+priceta);
                    quantity.setText(""+quantity1+"");
                }
            }
        }
        backcart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();

            }
        });
        checkout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DAO db = new DAO(getBaseContext());
                Billing bill = new Billing();
                bill.setDate(formatter.format(date));
                bill.setUserId(id);
                String texts="";
                for(Product pro: products){
                    for(Cart c : cart1){
                        if(pro.getProductId() == c.getProductId()){

                            texts =  texts+", "+pro.getProductName();
                        }
                    }
                }

                bill.setProductName(texts);
                bill.setTotalPrice(priceta);
                db.addBill(bill);
                db.deleteCartPro(id);
                startActivity(new Intent(getBaseContext(), history.class));
                finish();
            }
        });

    }
}