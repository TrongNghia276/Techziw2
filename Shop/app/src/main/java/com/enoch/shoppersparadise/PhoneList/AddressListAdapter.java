package com.enoch.shoppersparadise.PhoneList;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.enoch.shoppersparadise.DAO.DAO;
import com.enoch.shoppersparadise.MainActivity;
import com.enoch.shoppersparadise.ProductPage;
import com.enoch.shoppersparadise.R;
import com.enoch.shoppersparadise.createdb;
import com.enoch.shoppersparadise.model.Address;
import com.enoch.shoppersparadise.model.Cart;
import com.enoch.shoppersparadise.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.enoch.shoppersparadise.R.drawable.ic_dash_active;
import static com.enoch.shoppersparadise.R.drawable.ic_store;

public class AddressListAdapter  extends RecyclerView.Adapter<AddressListAdapter.AddressViewHolder> {

    private int lastCheckedPosition = -1;


    @NonNull
    @Override
    public AddressViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemaddresss,parent,false);

        return new AddressViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressViewHolder holder, int position) {

        Address address = addressList.get(position);
        holder.address1.setText(address.getLine1()+", "+address.getState()+", "+address.getCity()+", "+address.getCountry());
        holder.address2.setText(address.getLine2()+", "+address.getState()+", "+address.getCity()+", "+address.getCountry());
        holder.phone.setText("Phone: " +address.getPhone());
        holder.radioButton.setChecked(position == lastCheckedPosition);
        holder.radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DAO dao = new DAO(context);
                Cart cart = new Cart();
                SharedPreferences prf;
                prf = context.getSharedPreferences("users",context.MODE_PRIVATE);
                int id = prf.getInt("UserId",-1);

                SharedPreferences.Editor editor = prf.edit();

                editor.putString("phone", address.getPhone());
                editor.putString("line1","Line1: "+address.getLine1()+", "+address.getState()+", "+address.getCity()+", "+address.getCountry());
                editor.putInt("main",3);
                editor.putString("line2","Line2: "+address.getLine2()+", "+address.getState()+", "+address.getCity()+", "+address.getCountry());
                editor.commit();

                    v.getContext().startActivity(new Intent(v.getContext(), MainActivity.class));

            }
        });

    }



    @Override
    public int getItemCount() {
        return addressList.size();
    }

    List<Address> addressList ;
    Context context;
    public AddressListAdapter(List<Address> addressList,Context context) {
        this.addressList = addressList;
        this.context = context;
    }

    public class AddressViewHolder extends RecyclerView.ViewHolder{
        TextView phone,address1,address2;
        ImageView imagesProduct;

        RadioButton  radioButton;
        public AddressViewHolder(@NonNull View itemView){
            super(itemView);
                phone = itemView.findViewById(R.id.topphone);
                address1 = itemView.findViewById(R.id.itemaddres);
            address2 = itemView.findViewById(R.id.itemaddres2);


                radioButton = itemView.findViewById(R.id.radiobutton);
                radioButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int copyOfLastCheckedPosition = lastCheckedPosition;
                        lastCheckedPosition = getAdapterPosition();
                        notifyItemChanged(copyOfLastCheckedPosition);
                        notifyItemChanged(lastCheckedPosition);

                    }
                });

        }
    }
}
