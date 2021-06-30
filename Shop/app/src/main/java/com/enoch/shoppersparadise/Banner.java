package com.enoch.shoppersparadise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.enoch.shoppersparadise.mainAdapter.mainAdapter;

import java.util.ArrayList;
import java.util.List;

public class Banner extends AppCompatActivity {
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        ImageSlider imageSlider =  findViewById(R.id.slide12);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/shopper-e3a25.appspot.com/o/bn2.png?alt=media&token=7063e1c4-94ff-4f09-9a8c-d953fe4feca9"," ", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/shopper-e3a25.appspot.com/o/bn1.png?alt=media&token=965e7778-d0f9-4deb-b812-b08c976c223d"," ", ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);
        SharedPreferences prf;

        prf = getBaseContext().getSharedPreferences("users",getBaseContext().MODE_PRIVATE);


        SharedPreferences.Editor editor = prf.edit();
        imageSlider.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemSelected(int i) {

                editor.putInt("main",0);
                editor.commit();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
        title = findViewById(R.id.shopnow);
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putInt("main",0);
                editor.commit();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}