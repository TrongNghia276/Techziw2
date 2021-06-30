package com.enoch.shoppersparadise.mainAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.enoch.shoppersparadise.MainActivity;
import com.enoch.shoppersparadise.PhoneList.PhoneAdapter;
import com.enoch.shoppersparadise.ProductPage;
import com.enoch.shoppersparadise.R;
import com.enoch.shoppersparadise.createdb;
import com.enoch.shoppersparadise.login;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import static com.enoch.shoppersparadise.R.drawable.ic_acc;
import static com.enoch.shoppersparadise.R.drawable.ic_chat;
import static com.enoch.shoppersparadise.R.drawable.ic_dash;
import static com.enoch.shoppersparadise.R.drawable.ic_store;

public class SettingPage extends Fragment {
    RecyclerView recyclerView;
    ViewPager viewacc;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.oder_page,container,false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

}
