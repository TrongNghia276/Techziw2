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
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.enoch.shoppersparadise.AddressList;
import com.enoch.shoppersparadise.MainActivity;
import com.enoch.shoppersparadise.PhoneList.PhoneAdapter;
import com.enoch.shoppersparadise.R;
import com.enoch.shoppersparadise.address;
import com.enoch.shoppersparadise.createdb;
import com.enoch.shoppersparadise.history;
import com.enoch.shoppersparadise.login;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class  AccTabFragment extends Fragment {
    RecyclerView recyclerView;
    ViewPager viewacc,viewacc1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.oder_page,container,false);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayoutCompat login1 = view.findViewById(R.id.login);
        LinearLayoutCompat logout = view.findViewById(R.id.logout);
        LinearLayoutCompat historyLayout = view.findViewById(R.id.history);
        LinearLayoutCompat address1 = view.findViewById(R.id.addaddress);
        SharedPreferences prf;
        prf = getContext().getSharedPreferences("users",getContext().MODE_PRIVATE);
        int id = prf.getInt("UserId",-1);
        if(id == -1){
            logout.setVisibility(View.GONE);
            historyLayout.setVisibility(View.GONE);
            address1.setVisibility(View.GONE);
        }else{
            address1.setVisibility(View.VISIBLE);
            historyLayout.setVisibility(View.VISIBLE);
            logout.setVisibility(View.VISIBLE);
        }
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = prf.edit();
                editor.clear();
                editor.commit();

                logout.setVisibility(View.GONE);
                startActivity(new Intent(getContext(), login.class));
            }
        });
        historyLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(getContext(), history.class));
            }
        });
        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), login.class));
            }
        });
        address1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AddressList.class));
            }
        });
    }

}
