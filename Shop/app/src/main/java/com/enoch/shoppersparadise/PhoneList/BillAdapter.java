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
import com.enoch.shoppersparadise.model.Cart;
import com.enoch.shoppersparadise.model.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static com.enoch.shoppersparadise.R.drawable.btn_login;
import static com.enoch.shoppersparadise.R.drawable.ic_dash_active;
import static com.enoch.shoppersparadise.R.drawable.ic_store;

public class BillAdapter  extends RecyclerView.Adapter<BillAdapter.BillViewHolder> {

    @NonNull
    @Override
    public BillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itembill,parent,false);

        return new BillViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BillViewHolder holder, int position) {


        com.enoch.shoppersparadise.model.Cart cart = Cart.get(position);
        for(Product pro : product){

            if(pro.getProductId() ==   cart.getProductId()){

                holder.nameprobill.setText(pro.getProductName());
                holder.pricebill.setText("$"+pro.getPrice()+"");
                holder.quabill.setText(cart.getQuantity()+"");
            }}

    }

    @Override
    public int getItemCount() {



        return Cart.size();
    }



    List<Cart> Cart ;
    List<Product> product;
    Context context;
    public BillAdapter( List<Cart> Cart,List<Product> product ,Context context) {
        this.Cart = Cart;
        this.product = product;
        this.context = context;

    }

    public class BillViewHolder extends RecyclerView.ViewHolder{
        TextView pricebill,quabill,nameprobill,delqua,addqua,pricetotal,phonecart,addresscart,addresscart2;
        EditText Quality;
        ImageView imageProduct;
        ViewPager viewPager;

        RadioButton radioButton;
        public BillViewHolder(@NonNull View itemView){
            super(itemView);
            pricebill = itemView.findViewById(R.id.pricebill);
            quabill = itemView.findViewById(R.id.quabill);
            nameprobill = itemView.findViewById(R.id.nameprobill);

        }
    }
}
