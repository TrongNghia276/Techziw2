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

public class ShoesAdapter  extends RecyclerView.Adapter<ShoesAdapter.ShoesViewHolder> {

    @NonNull
    @Override
    public ShoesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemshirt,parent,false);

        return new ShoesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoesViewHolder holder, int position) {

        Product product = products.get(position);


        holder.textshirt.setText(product.getProductName());

        Picasso.get().load(product.getProductImage()).into(holder.imgaes);
        holder.imgaes.setOnClickListener(new View.OnClickListener() {
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
        });holder.textshirt.setOnClickListener(new View.OnClickListener() {
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
    public ShoesAdapter(List<Product> products,Context context) {
        this.products = products;
        this.context = context;
    }

    public class ShoesViewHolder extends RecyclerView.ViewHolder{
        TextView textshirt;
        ImageView imgaes;
        public ShoesViewHolder(@NonNull View itemView){
            super(itemView);


            imgaes = itemView.findViewById(R.id.imageshirt);

            textshirt = itemView.findViewById(R.id.textshirt);
        }
    }
}
