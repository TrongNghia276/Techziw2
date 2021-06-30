package com.enoch.shoppersparadise.mainAdapter;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.SearchView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.enoch.shoppersparadise.DAO.DAO;
import com.enoch.shoppersparadise.PhoneList.PhoneAdapter;
import com.enoch.shoppersparadise.PhoneList.ShopAdapter;
import com.enoch.shoppersparadise.ProductPage;
import com.enoch.shoppersparadise.R;
import com.enoch.shoppersparadise.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShopPage extends Fragment {
    RecyclerView recyclerViewShirt,recyclerViewPhone,recyclerViewShoes;
    ViewPager viewacc;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.shop,container,false);


// Hide the status bar.

// Remember that you should never show the action bar if the
// status bar is hidden, so hide that too if necessary.

        return root;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SearchView searchView;
        searchView = view.findViewById(R.id.searchbar);


        List<Product> Sproductsshose4 = new ArrayList<>();

        List<Product> Sproductsshirt4 = new ArrayList<>();

        List<Product> Sproductsphone4 = new ArrayList<>();
        AppCompatTextView phonet,shoest,shirtt,sort1,sort2;
        DAO db = new DAO(getContext());
        recyclerViewShirt = view.findViewById(R.id.Shirtshop);
        recyclerViewPhone = view.findViewById(R.id.Phoneshop);
        recyclerViewShoes = view.findViewById(R.id.ShoesShop);
        phonet = view.findViewById(R.id.textphones);
        shoest = view.findViewById(R.id.textshoess);
        shirtt = view.findViewById(R.id.textshirts);
        sort1 = view.findViewById(R.id.sort1);
        sort2 = view.findViewById(R.id.sort2);
        List<Product> products = db.getAllProduct();
        List<Product> productsphone = new ArrayList<>();
        List<Product> productsshirt = new ArrayList<>();
        List<Product> productsshose = new ArrayList<>();
        for(Product p : products){
            if(p.getCategoryName().equals("Phone")){
                Sproductsphone4.add(p);
                productsphone.add(p);
            }else if(p.getCategoryName().equals("shoes")){
                Sproductsshose4.add(p);
                productsshose.add(p);
            }else if(p.getCategoryName().equals("shirt")){
                Sproductsshirt4.add(p);
                productsshirt.add(p);
            }
        }
        ShopAdapter phonedapter = new ShopAdapter(productsphone,getContext());
        recyclerViewPhone.setHasFixedSize(true);
        recyclerViewPhone.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerViewPhone.setAdapter(phonedapter);
        ShopAdapter shirtdapter = new ShopAdapter(productsshirt,getContext());
        recyclerViewShirt.setHasFixedSize(true);
        recyclerViewShirt.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerViewShirt.setAdapter(shirtdapter);
        ShopAdapter shosedapter = new ShopAdapter(productsshose,getContext());
        recyclerViewShoes.setHasFixedSize(true);
        recyclerViewShoes.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerViewShoes.setAdapter(shosedapter);

        sort1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(Sproductsphone4, new Comparator<Product>() {

                    @Override
                    public int compare(Product p1, Product p2) {
                        return p2.getPrice() - p1.getPrice();

                    }

                });

                Collections.sort(Sproductsshirt4, new Comparator<Product>() {

                    @Override
                    public int compare(Product p1, Product p2) {
                        return p2.getPrice() - p1.getPrice();

                    }

                });
                Collections.sort(Sproductsshose4, new Comparator<Product>() {

                    @Override
                    public int compare(Product p1, Product p2) {
                        return p2.getPrice() - p1.getPrice();

                    }

                });
                ShopAdapter phonedapter = new ShopAdapter(Sproductsphone4,getContext());
                recyclerViewPhone.setHasFixedSize(true);
                recyclerViewPhone.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
                recyclerViewPhone.setAdapter(phonedapter);
                ShopAdapter shirtdapter = new ShopAdapter(Sproductsshirt4,getContext());
                recyclerViewShirt.setHasFixedSize(true);
                recyclerViewShirt.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
                recyclerViewShirt.setAdapter(shirtdapter);
                ShopAdapter shosedapter = new ShopAdapter(Sproductsshose4,getContext());
                recyclerViewShoes.setHasFixedSize(true);
                recyclerViewShoes.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
                recyclerViewShoes.setAdapter(shosedapter);
            }
        });
        sort2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(Sproductsshose4, new Comparator<Product>() {

                    @Override
                    public int compare(Product p1, Product p2) {
                        return p1.getPrice() - p2.getPrice();

                    }

                });
                Collections.sort(Sproductsshirt4, new Comparator<Product>() {

                    @Override
                    public int compare(Product p1, Product p2) {
                        return p1.getPrice() - p2.getPrice();

                    }

                });
                Collections.sort(Sproductsphone4, new Comparator<Product>() {

                    @Override
                    public int compare(Product p1, Product p2) {
                        return p1.getPrice() - p2.getPrice();

                    }

                });
                ShopAdapter phonedapter = new ShopAdapter(Sproductsphone4,getContext());
                recyclerViewPhone.setHasFixedSize(true);
                recyclerViewPhone.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
                recyclerViewPhone.setAdapter(phonedapter);
                ShopAdapter shirtdapter = new ShopAdapter(Sproductsshirt4,getContext());
                recyclerViewShirt.setHasFixedSize(true);
                recyclerViewShirt.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
                recyclerViewShirt.setAdapter(shirtdapter);
                ShopAdapter shosedapter = new ShopAdapter(Sproductsshose4,getContext());
                recyclerViewShoes.setHasFixedSize(true);
                recyclerViewShoes.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
                recyclerViewShoes.setAdapter(shosedapter);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {


                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                Sproductsphone4.clear();

                Sproductsshose4.clear();
                Sproductsshirt4.clear();
                List<Product> Sproductsshose = new ArrayList<>();

                List<Product> Sproductsshirt = new ArrayList<>();

                List<Product> Sproductsphone = new ArrayList<>();
                for(Product p : productsphone){
                    if(p.getProductName().toLowerCase().contains(newText.toLowerCase())){
                        Sproductsphone.add(p);
                        Sproductsphone4.add(p);
                    }
                }
                for(Product p : productsshirt){
                    if(p.getProductName().toLowerCase().contains(newText.toLowerCase())){
                        Sproductsshirt.add(p);
                        Sproductsshirt4.add(p);
                    }
                }
                for(Product p : productsshose){
                    if(p.getProductName().toLowerCase().contains(newText.toLowerCase())){
                        Sproductsshose.add(p);
                        Sproductsshose4.add(p);
                    }
                }

                ShopAdapter phonedapter = new ShopAdapter(Sproductsphone,getContext());
                recyclerViewPhone.setHasFixedSize(true);
                recyclerViewPhone.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
                recyclerViewPhone.setAdapter(phonedapter);
                ShopAdapter shirtdapter = new ShopAdapter(Sproductsshirt,getContext());
                recyclerViewShirt.setHasFixedSize(true);
                recyclerViewShirt.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
                recyclerViewShirt.setAdapter(shirtdapter);
                ShopAdapter shosedapter = new ShopAdapter(Sproductsshose,getContext());
                recyclerViewShoes.setHasFixedSize(true);
                recyclerViewShoes.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
                recyclerViewShoes.setAdapter(shosedapter);
                if(Sproductsphone.size() ==0){
                    recyclerViewPhone.setVisibility(View.GONE);
                    phonet.setVisibility(View.GONE);
                }else{
                    recyclerViewPhone.setVisibility(View.VISIBLE);
                    phonet.setVisibility(View.VISIBLE);
                }
                if(Sproductsshirt.size() ==0){
                    recyclerViewShirt.setVisibility(View.GONE);
                    shirtt.setVisibility(View.GONE);
                }else{
                    recyclerViewShirt.setVisibility(View.VISIBLE);
                    shirtt.setVisibility(View.VISIBLE);
                }
                if(Sproductsshose.size() ==0){
                    recyclerViewShoes.setVisibility(View.GONE);
                    shoest.setVisibility(View.GONE);
                }else{
                    recyclerViewShoes.setVisibility(View.VISIBLE);
                    shoest.setVisibility(View.VISIBLE);
                }
                return false;
            }
        });
    }

}
