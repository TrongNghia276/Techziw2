package com.enoch.shoppersparadise.loginFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.enoch.shoppersparadise.DAO.DAO;
import com.enoch.shoppersparadise.R;
import com.enoch.shoppersparadise.model.User;
import com.google.firebase.auth.FirebaseAuth;

public class SignupTabFragment  extends Fragment {
    private FirebaseAuth mAuth;
    ViewPager viewPager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.register_fragment,container,false);
        return root;
    }
    AppCompatEditText email,password,confirm,fullName,username;
    AppCompatButton btn_register;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        email = view.findViewById(R.id.email_sign);
        password = view.findViewById(R.id.pass_sign);
        username = view.findViewById(R.id.username_sign);
        fullName = view.findViewById(R.id.fullname_sign);
        btn_register = view.findViewById(R.id.btnsign);

        mAuth = FirebaseAuth.getInstance();
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DAO db = new DAO(getActivity().getBaseContext());
                User user = new User();
                user.setEmail(email.getText().toString().trim());

                user.setPassword(password.getText().toString().trim());
                user.setFullName(fullName.getText().toString().trim());
                user.setUserName(username.getText().toString().trim());
                db.addUser(user);
                viewPager = getActivity().findViewById(R.id.view_pager_login);
                viewPager.setCurrentItem(0);
            }
        });
    }
}
