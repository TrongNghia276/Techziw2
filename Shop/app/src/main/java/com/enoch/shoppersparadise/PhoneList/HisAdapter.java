package com.enoch.shoppersparadise.PhoneList;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.enoch.shoppersparadise.DAO.DAO;
import com.enoch.shoppersparadise.MainActivity;
import com.enoch.shoppersparadise.ProductPage;
import com.enoch.shoppersparadise.R;
import com.enoch.shoppersparadise.createdb;
import com.enoch.shoppersparadise.model.Address;
import com.enoch.shoppersparadise.model.Billing;
import com.enoch.shoppersparadise.model.Cart;
import com.enoch.shoppersparadise.model.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static com.enoch.shoppersparadise.R.drawable.btn_login;
import static com.enoch.shoppersparadise.R.drawable.ic_dash_active;
import static com.enoch.shoppersparadise.R.drawable.ic_store;

public class HisAdapter  extends RecyclerView.Adapter<HisAdapter.HisViewHolder> {

    @NonNull
    @Override
    public HisViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemhistory,parent,false);

        return new HisViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HisViewHolder holder, int position) {


        com.enoch.shoppersparadise.model.Billing bill1 = bill.get(position);
        holder.pricebill.setText("$"+bill1.getTotalPrice()+"");
        holder.date.setText("Date of purchase: "+bill1.getDate());
        holder.nameprobill.setText("All Product: "+bill1.getProductName());

    }

    @Override
    public int getItemCount() {



        return bill.size();
    }



    List<Billing> bill ;
    List<Product> product;
    Context context;
    public HisAdapter(List<Billing> bill , Context context) {
        this.bill = bill;
        this.context = context;

    }

    public class HisViewHolder extends RecyclerView.ViewHolder{
        TextView pricebill,date,nameprobill,delqua,addqua,pricetotal,phonecart,addresscart,addresscart2;
        EditText Quality;
        ImageView imageProduct;
        ViewPager viewPager;

        RadioButton radioButton;
        public HisViewHolder(@NonNull View itemView){
            super(itemView);
            pricebill = itemView.findViewById(R.id.pricehis);
            date = itemView.findViewById(R.id.datehis);
            nameprobill = itemView.findViewById(R.id.nameprohis1);

        }
    }
}
