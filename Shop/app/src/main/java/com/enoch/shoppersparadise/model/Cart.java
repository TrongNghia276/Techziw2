package com.enoch.shoppersparadise.model;

public class Cart {
    int cartId;
    int productId;
    int quantity;
    int couponId;
    int addressId;
    int userId;

    public Cart() {
    }

    public Cart(int cartId, int productId, int quantity, int couponId, int addressId, int userId) {
        this.cartId = cartId;
        this.productId = productId;
        this.quantity = quantity;
        this.couponId = couponId;
        this.addressId = addressId;
        this.userId = userId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
