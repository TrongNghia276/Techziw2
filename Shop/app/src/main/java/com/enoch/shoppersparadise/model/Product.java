package com.enoch.shoppersparadise.model;

public class Product {
    int productId;
    String productName;
    String productImage;
    int Price;
    int Stock;
    String Description;

    String CategoryName;

    public Product() {
    }

    public Product(int productId, String productName, String productImage, int price, int stock, String description, String categoryName) {
        this.productId = productId;
        this.productName = productName;
        this.productImage = productImage;
        Price = price;
        Stock = stock;
        Description = description;
        CategoryName = categoryName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
}
