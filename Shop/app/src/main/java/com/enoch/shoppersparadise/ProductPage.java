package com.enoch.shoppersparadise;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.enoch.shoppersparadise.DAO.DAO;
import com.enoch.shoppersparadise.model.Cart;
import com.enoch.shoppersparadise.model.Product;
import com.squareup.picasso.Picasso;

public class ProductPage extends AppCompatActivity {

    ImageView image;
    Button button;
    TextView name,price,description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.product);
        image = findViewById(R.id.imageproduct);
        name =findViewById(R.id.textproductname);
        button=findViewById(R.id.addcart);
        price = findViewById(R.id.Priceproduct);
        description = findViewById(R.id.descrip);
        Intent i = getIntent();
        int id  = i.getIntExtra("id",100);
        String image1 = i.getStringExtra("image");
        int pri = i.getIntExtra("price",0);
        String names = i.getStringExtra("name");
        String Desc = i.getStringExtra("des");
        Integer y = new Integer(id);
        price.setText("$"+pri+"");
        description.setText(Desc);
        name.setText(names);
        Picasso.get().load(image1).into(image);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                SharedPreferences prf;



                prf = getBaseContext().getSharedPreferences("users",getBaseContext().MODE_PRIVATE);

                SharedPreferences.Editor editor = prf.edit();
                int userid = prf.getInt("UserId",-1);
                DAO db = new DAO(getBaseContext());
                Cart cart = new Cart();
                cart.setProductId(id);
                cart.setUserId(userid);
                cart.setQuantity(1);
               cart.setCouponId(-1);
               cart.setAddressId(-1);
                db.addCart(cart);
                Toast.makeText(getApplicationContext(), "ADDCART OK", Toast.LENGTH_LONG).show();
                new AlertDialog.Builder(ProductPage.this)
                        .setTitle("Add products to cart successfully.")
                        .setMessage("Add products to cart successfully.")
                        .setCancelable(false)
                        .setPositiveButton("Go to Cart", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();

                                editor.putInt("main",2);
                                editor.commit();
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                finish();
                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                              dialog.cancel();
                    }
                }).show();
            }
        });
    }


}