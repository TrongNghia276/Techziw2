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

public class CartAdapters  extends RecyclerView.Adapter<CartAdapters.CartViewHolder> {

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemcart,parent,false);

        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {


        com.enoch.shoppersparadise.model.Cart cart = Cart.get(position);

        int pricetotal = 0;
        for(Product pro : product){

                if(pro.getProductId() ==   cart.getProductId()){

                    holder.title.setText(pro.getProductName());
                    holder.price.setText("$"+pro.getPrice());
                    Picasso.get().load(pro.getProductImage()).into(holder.imageProduct);

                    holder.Quality.setText(cart.getQuantity()+"");
                    pricetotal = cart.getQuantity()*pro.getPrice();
                    holder.Quality.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {

                        }

                        @Override
                        public void afterTextChanged(Editable s) {
                            if(s.length() > 0){
                                String totalqua1 = holder.Quality.getText().toString();
                                com.enoch.shoppersparadise.model.Cart cart2 = new Cart();
                                cart2.setUserId(cart.getUserId());
                                cart2.setAddressId(cart.getAddressId());
                                cart2.setCartId(cart.getCartId());
                                cart2.setCouponId(cart.getCouponId());
                                cart2.setQuantity(Integer.parseInt(totalqua1));
                                cart2.setProductId(cart.getProductId());

                                Cart.set(position,cart2);
                                DAO dao = new DAO(context);
                                dao.updateCart(cart2);

                            }
                        }
                    });
                    holder.delete.setOnClickListener(new View.OnClickListener(){

                        @Override
                        public void onClick(View v) {
                            DAO dao = new DAO(context);
                            dao.deleteCart(cart.getCartId());
                            Cart.remove(position);
                            notifyDataSetChanged();
                        }
                    });
                    holder.addqua.setOnClickListener(new View.OnClickListener(){

                        @Override
                        public void onClick(View v) {

                            int totalqua = cart.getQuantity() +1;
                            com.enoch.shoppersparadise.model.Cart cart2 = new Cart();
                            cart2.setUserId(cart.getUserId());
                            cart2.setAddressId(cart.getAddressId());
                            cart2.setCartId(cart.getCartId());
                            cart2.setCouponId(cart.getCouponId());
                            cart2.setQuantity(totalqua);
                            cart2.setProductId(cart.getProductId());

                            Integer y = new Integer(totalqua);
                            holder.Quality.setText(y.toString());
                            DAO dao = new DAO(context);
                            dao.updateCart(cart2);
                            Cart.set(position,cart2);

                            notifyDataSetChanged();
                        }
                    });
                    holder.delqua.setOnClickListener(new View.OnClickListener(){

                        @Override
                        public void onClick(View v) {
                            if(cart.getQuantity() <= 1){
                                DAO dao = new DAO(context);
                                dao.deleteCart(cart.getCartId());
                                Cart.remove(position);
                                notifyDataSetChanged();
                            }else{
                                int totalqua2 = cart.getQuantity() -1;
                                com.enoch.shoppersparadise.model.Cart cart2 = new Cart();
                                cart2.setUserId(cart.getUserId());
                                cart2.setAddressId(cart.getAddressId());
                                cart2.setCartId(cart.getCartId());
                                cart2.setCouponId(cart.getCouponId());
                                cart2.setQuantity(totalqua2);
                                cart2.setProductId(cart.getProductId());

                                Integer y = new Integer(totalqua2);
                                holder.Quality.setText(y.toString());
                                DAO dao = new DAO(context);
                                dao.updateCart(cart2);
                                Cart.set(position,cart2);

                                notifyDataSetChanged();

                            }

                        }
                    });

                }
            }


    }

    @Override
    public int getItemCount() {



        return Cart.size();
    }



    List<Cart> Cart ;
    List<Product> product;
    Context context;
    public CartAdapters( List<Cart> Cart,List<Product> product ,Context context) {
       this.Cart = Cart;
       this.product = product;
        this.context = context;

    }

    public class CartViewHolder extends RecyclerView.ViewHolder{
        TextView title,price,delete,delqua,addqua,pricetotal,phonecart,addresscart,addresscart2;
        EditText Quality;
        ImageView imageProduct;
        ViewPager viewPager;
        public CartViewHolder(@NonNull View itemView){
            super(itemView);
            Quality = itemView.findViewById(R.id.quality);
            addqua = itemView.findViewById(R.id.addqua1);
            delqua = itemView.findViewById(R.id.detelequa);
            title = itemView.findViewById(R.id.titlecart);
            price = itemView.findViewById(R.id.pricecart);
            imageProduct = itemView.findViewById(R.id.imagecart);
            delete = itemView.findViewById(R.id.deletecart);

        }
    }
}
