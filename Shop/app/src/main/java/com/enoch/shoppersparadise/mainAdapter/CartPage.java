package com.enoch.shoppersparadise.mainAdapter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.enoch.shoppersparadise.AddressList;
import com.enoch.shoppersparadise.Bill;
import com.enoch.shoppersparadise.DAO.DAO;
import com.enoch.shoppersparadise.MainActivity;
import com.enoch.shoppersparadise.PhoneList.BillAdapter;
import com.enoch.shoppersparadise.PhoneList.CartAdapters;
import com.enoch.shoppersparadise.PhoneList.PhoneAdapter;
import com.enoch.shoppersparadise.PhoneList.ShopAdapter;
import com.enoch.shoppersparadise.R;
import com.enoch.shoppersparadise.createdb;
import com.enoch.shoppersparadise.login;
import com.enoch.shoppersparadise.model.Address;
import com.enoch.shoppersparadise.model.Cart;
import com.enoch.shoppersparadise.model.Product;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends Fragment {
    RecyclerView recyclerView;
    AppCompatTextView pricetotal1,change,phonecart,addresscart,addresscart2,bottomcard;
    ViewPager viewacc;
    Button gotologin;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.cartpage,container,false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedPreferences prf;
        Button button,reload ;

        reload = view.findViewById(R.id.reload);
        button = view.findViewById(R.id.gotologin);
        bottomcard = view.findViewById(R.id.bottomcard);
        phonecart = view.findViewById(R.id.phonecart);
        addresscart = view.findViewById(R.id.addresscart);
        addresscart2 = view.findViewById(R.id.addresscart2);

        gotologin = view.findViewById(R.id.gotologin);
        gotologin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), login.class));
            }
        });
        prf = getActivity().getBaseContext().getSharedPreferences("users",getActivity().getBaseContext().MODE_PRIVATE);
        int id = prf.getInt("UserId",-1);
        if(id == -1){
            bottomcard.setVisibility(View.GONE);
            phonecart.setVisibility(View.GONE);
            addresscart.setVisibility(View.GONE);
            addresscart2.setVisibility(View.GONE);
            reload.setVisibility(View.GONE);
            button.setVisibility(View.VISIBLE);
        }else{
            bottomcard.setVisibility(View.VISIBLE);
            phonecart.setVisibility(View.VISIBLE);
            addresscart.setVisibility(View.VISIBLE);
            addresscart2.setVisibility(View.VISIBLE);
            reload.setVisibility(View.VISIBLE);
            button.setVisibility(View.GONE);
            DAO db = new DAO(getActivity().getBaseContext());
            AppCompatTextView phone,add,add2;
            phone = view.findViewById(R.id.phonecart);
            phone.setText("ok"+id);
            add= view.findViewById(R.id.addresscart);

            pricetotal1= view.findViewById(R.id.totalp);

            add2= view.findViewById(R.id.addresscart2);
            List<Address> address1 = db.getListAddress(id);
            recyclerView = view.findViewById(R.id.recarta);
            List<Cart> cart = db.getListCart(id);
            List<Product> products = db.getAllProduct();

            List<Address> adds = db.getListAddress(id);
                if(prf.getString("phone","-1").equals("-1")){
                    phonecart.setVisibility(View.GONE);
                    addresscart.setVisibility(View.GONE);
                    addresscart2.setVisibility(View.GONE);

                }else{
                    phonecart.setVisibility(View.VISIBLE);
                    addresscart.setVisibility(View.VISIBLE);
                    addresscart2.setVisibility(View.VISIBLE);
                    phonecart.setText("Phone: "+prf.getString("phone","-1"));
                    addresscart.setText(prf.getString("line1",""));
                    addresscart2.setText(prf.getString("line2",""));
                }





            CartAdapters sadapter = new CartAdapters(cart,products,getContext());
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(sadapter);
            int pricet = 0;
            for(Product pro: products){
                for(Cart c : cart){
                    if(pro.getProductId() == c.getProductId()){
                        pricet = pricet +pro.getPrice()*c.getQuantity();
                        pricetotal1.setText("$"+pricet);
                        sadapter.notifyDataSetChanged();
                    }
                }
            }
            change =  view.findViewById(R.id.changed);
            change.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {

                    startActivity(new Intent(getActivity(), AddressList.class));

                }
            });
            reload.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    List<Cart> cart = db.getListCart(id);
                    List<Product> products = db.getAllProduct();
                    int pricet = 0;
                    for(Product pro: products){
                        for(Cart c : cart){
                            if(pro.getProductId() == c.getProductId()){
                                pricet = pricet +pro.getPrice()*c.getQuantity();
                                pricetotal1.setText("$"+pricet);
                                sadapter.notifyDataSetChanged();
                            }
                        }
                    }
                }
            });

            bottomcard.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getActivity(), Bill.class));
                }
            });

        }
    }

}
