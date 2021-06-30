package com.enoch.shoppersparadise.mainAdapter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.enoch.shoppersparadise.DAO.DAO;
import com.enoch.shoppersparadise.MainActivity;
import com.enoch.shoppersparadise.PhoneList.PhoneAdapter;
import com.enoch.shoppersparadise.PhoneList.ShirtAdapter;
import com.enoch.shoppersparadise.PhoneList.ShoesAdapter;
import com.enoch.shoppersparadise.R;
import com.enoch.shoppersparadise.login;
import com.enoch.shoppersparadise.model.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class dashBoardTabFragment extends Fragment {
    RecyclerView recyclerView,shirt,recyclerView2;
    ViewPager viewPager;
    ImageView imageView;
    AppCompatButton clickshop;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.dashboard,container,false);



        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageSlider imageSlider =  view.findViewById(R.id.slide1);
        SharedPreferences prf;

        prf = getContext().getSharedPreferences("users",getContext().MODE_PRIVATE);

        imageView = view.findViewById(R.id.imageban);
        clickshop = view.findViewById(R.id.shopclick);




        SharedPreferences.Editor editor = prf.edit();
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/shopper-e3a25.appspot.com/o/samsung-galaxy-note-10-den.png?alt=media&token=851704cb-3f14-4cf6-a5e1-c38e42cfea1f").into(imageView);
        ImageSlider imageSlider1 =  view.findViewById(R.id.slide123);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/shopper-e3a25.appspot.com/o/bn2.png?alt=media&token=7063e1c4-94ff-4f09-9a8c-d953fe4feca9"," ", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/shopper-e3a25.appspot.com/o/bn1.png?alt=media&token=965e7778-d0f9-4deb-b812-b08c976c223d"," ", ScaleTypes.FIT));
        List<SlideModel> slideModels1 = new ArrayList<>();
        slideModels1.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/shopper-e3a25.appspot.com/o/banner2.png?alt=media&token=69a50e80-d386-41ed-b9d5-4222ec871d15","  ", ScaleTypes.FIT));
        slideModels1.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/shopper-e3a25.appspot.com/o/banner3.png?alt=media&token=ceb5a865-c2af-482e-b82c-fb9e23827992"," ", ScaleTypes.FIT));
        imageSlider.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemSelected(int i) {
                editor.putInt("main",0);
                editor.commit();
                startActivity(new Intent(getContext(), MainActivity.class));
            }
        });
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);
        imageSlider1.setImageList(slideModels1, ScaleTypes.FIT);
        shirt =view.findViewById(R.id.Shirt);
        recyclerView = view.findViewById(R.id.smartphonerecy);
        recyclerView2 = view.findViewById(R.id.Shoes);
        recyclerViewPhone();
        clickshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("main",0);
                editor.commit();
                startActivity(new Intent(getContext(), MainActivity.class));
            }
        });
    }
    private void recyclerViewPhone(){

        DAO db = new DAO(getContext());
        List<Product> products = db.getAllProduct();
        List<Product> productshirt = new ArrayList<>();
        for(Product p : products){
            if(p.getCategoryName().equals("shirt")){
                productshirt.add(p);
            }
        }
        ShirtAdapter shirtAdapter = new ShirtAdapter(productshirt,getContext());
        shirt.setHasFixedSize(true);
        shirt.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        List<Product> productsphone = new ArrayList<>();
        for(Product p : products){
            if(p.getCategoryName().equals("Phone")){
                productsphone.add(p);
            }
        }
        PhoneAdapter padapter = new PhoneAdapter(productsphone,getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(padapter);

        shirt.setAdapter(shirtAdapter);
        List<Product> productshoes = new ArrayList<>();
        for(Product p : products){
            if(p.getCategoryName().equals("shoes")){
                productshoes.add(p);
            }
        }
        ShoesAdapter acs = new ShoesAdapter(productshoes,getContext());
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerView2.setAdapter(acs);
    }
}
