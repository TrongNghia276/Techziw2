package com.enoch.shoppersparadise.loginFragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;

import com.enoch.shoppersparadise.DAO.DAO;
import com.enoch.shoppersparadise.MainActivity;
import com.enoch.shoppersparadise.R;
import com.enoch.shoppersparadise.model.User;

import java.util.List;


public class LoginTabFragment extends Fragment {

    AppCompatEditText email_login,pass_login,email_register,pass_register,confirm_pass;
    Button btn_login;
    LinearLayoutCompat loading;

    SharedPreferences pref;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_fragment,container,false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_login = view.findViewById(R.id.btn_login);
        email_login =view.findViewById(R.id.email_login);
        pass_login = view.findViewById(R.id.password_login);
        pref = getContext().getSharedPreferences("users",getContext().MODE_PRIVATE);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DAO db = new DAO(getActivity().getBaseContext());
                List<User> users = db.getAllUser();
                boolean a = false;
                for (User cn : users) {
                    if(cn.getEmail().equals(email_login.getText().toString())){
                        if(cn.getPassword().equals(pass_login.getText().toString())){

                            SharedPreferences.Editor editor = pref.edit();

                            editor.putInt("UserId", cn.getUserId());
                            editor.putString("UserFullName", cn.getFullName());
                            editor.commit();
                            a=true;
                            startActivity(new Intent(getActivity(),MainActivity.class));
                            getActivity().finish();

                        }
                    }
                }
                if(a==false){
                    new AlertDialog.Builder(getActivity())
                            .setTitle("Wrong email or password")
                            .setMessage("Wrong email or password. Please try again")
                            .setCancelable(false)
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();

                                }
                            }).show();
                }

            }
        });
    }





}
