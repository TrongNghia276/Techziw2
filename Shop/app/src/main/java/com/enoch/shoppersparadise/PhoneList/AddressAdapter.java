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
import com.enoch.shoppersparadise.model.Address;
import com.enoch.shoppersparadise.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.enoch.shoppersparadise.R.drawable.ic_dash_active;
import static com.enoch.shoppersparadise.R.drawable.ic_store;

public class AddressAdapter  extends RecyclerView.Adapter<AddressAdapter.AddressViewHolder> {

    @NonNull
    @Override
    public AddressViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cartpage,parent,false);

        return new AddressViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressViewHolder holder, int position) {

        Address address = addressList.get(position);


    }



    @Override
    public int getItemCount() {
        return addressList.size();
    }

    List<Address> addressList ;
    Context context;
    public AddressAdapter(List<Address> addressList,Context context) {
        this.addressList = addressList;
        this.context = context;
    }

    public class AddressViewHolder extends RecyclerView.ViewHolder{
        TextView Textproduct,Price;
        ImageView imagesProduct;

        public AddressViewHolder(@NonNull View itemView){
            super(itemView);


            imagesProduct = itemView.findViewById(R.id.imageshop);

            Textproduct = itemView.findViewById(R.id.textshop);
            Price = itemView.findViewById(R.id.price);
        }
    }
}
