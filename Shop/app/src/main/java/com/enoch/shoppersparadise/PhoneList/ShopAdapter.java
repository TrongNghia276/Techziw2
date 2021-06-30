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
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.enoch.shoppersparadise.ProductPage;
import com.enoch.shoppersparadise.R;
import com.enoch.shoppersparadise.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.enoch.shoppersparadise.R.drawable.ic_dash_active;
import static com.enoch.shoppersparadise.R.drawable.ic_store;

public class ShopAdapter  extends RecyclerView.Adapter<ShopAdapter.ShopViewHolder> {

    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemshop,parent,false);

        return new ShopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopViewHolder holder, int position) {

        Product product = products.get(position);


        holder.Textproduct.setText(product.getProductName());
        Integer y = new Integer(product.getPrice());
        holder.Price.setText("$ "+y.toString());
        Picasso.get().load(product.getProductImage()).into(holder.imagesProduct);
        holder.imagesProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ProductPage.class);
                i.putExtra("id",product.getProductId());
                i.putExtra("price",product.getPrice());
                i.putExtra("des",product.getDescription());
                i.putExtra("name",product.getProductName());

                i.putExtra("image",product.getProductImage());
                v.getContext().startActivity(i);
            }
        }); holder.Price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ProductPage.class);
                i.putExtra("id",product.getProductId());
                i.putExtra("price",product.getPrice());
                i.putExtra("des",product.getDescription());

                i.putExtra("name",product.getProductName());
                i.putExtra("image",product.getProductImage());
                v.getContext().startActivity(i);
            }
        });holder.Textproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ProductPage.class);
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
    public ShopAdapter(List<Product> products,Context context) {
        this.products = products;
        this.context = context;
    }

    public class ShopViewHolder extends RecyclerView.ViewHolder{
        TextView Textproduct,Price;
        ImageView imagesProduct;

        public ShopViewHolder(@NonNull View itemView){
            super(itemView);


            imagesProduct = itemView.findViewById(R.id.imageshop);

            Textproduct = itemView.findViewById(R.id.textshop);
            Price = itemView.findViewById(R.id.price);
        }
    }
}
