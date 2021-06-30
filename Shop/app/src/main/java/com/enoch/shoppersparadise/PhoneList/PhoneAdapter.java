package com.enoch.shoppersparadise.PhoneList;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.enoch.shoppersparadise.MainActivity;
import com.enoch.shoppersparadise.ProductPage;
import com.enoch.shoppersparadise.R;
import com.enoch.shoppersparadise.createdb;
import com.enoch.shoppersparadise.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.enoch.shoppersparadise.R.drawable.btn_login;
import static com.enoch.shoppersparadise.R.drawable.ic_dash_active;
import static com.enoch.shoppersparadise.R.drawable.ic_store;

public class PhoneAdapter  extends RecyclerView.Adapter<PhoneAdapter.PhoneViewHolder> {

    @NonNull
    @Override
    public PhoneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_phone,parent,false);

        return new PhoneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneViewHolder holder, int position) {

       Product product = products.get(position);

//if you are indeed loading the first one this should be in top, before the iteration.


        holder.textphone.setText(product.getProductName());

        Picasso.get().load(product.getProductImage()).into(holder.imageProduct);
        holder.imageProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),ProductPage.class);
                i.putExtra("id",product.getProductId());
                i.putExtra("price",product.getPrice());
                i.putExtra("des",product.getDescription());

                i.putExtra("name",product.getProductName());
                i.putExtra("image",product.getProductImage());
                v.getContext().startActivity(i);
            }
        }); holder.textphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),ProductPage.class);
                i.putExtra("id",product.getProductId());
                i.putExtra("price",product.getPrice());
                i.putExtra("des",product.getDescription());

                i.putExtra("name",product.getProductName());
                i.putExtra("image",product.getProductImage());
                v.getContext().startActivity(i);
            }
        });
    }



    @Override
    public int getItemCount() {
       return products.size();
    }

    List<Product> products ;
    Context context;
    public PhoneAdapter(List<Product> products,Context context) {
        this.products = products;
        this.context = context;
    }

    public class PhoneViewHolder extends RecyclerView.ViewHolder{
         TextView textphone;
         ImageView imageProduct;
        public PhoneViewHolder(@NonNull View itemView){
            super(itemView);


            imageProduct = itemView.findViewById(R.id.imagephone);

            textphone = itemView.findViewById(R.id.textphone);
        }
    }
}
