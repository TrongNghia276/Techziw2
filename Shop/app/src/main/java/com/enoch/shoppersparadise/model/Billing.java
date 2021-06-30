package com.enoch.shoppersparadise.model;

import java.util.Date;

public class Billing {
    int BillID;
    int UserId;
    String FullName;
    String date;
    String ProductName;
    String Phone;
    String Line1;
    String Line2;
    int TotalPrice;
    String payment;

    public Billing() {
    }

    public Billing(int billID, int userId, String fullName, String date, String productName, String phone, String line1, String line2, int totalPrice, String payment) {
        BillID = billID;
        UserId = userId;
        FullName = fullName;
        this.date = date;
        ProductName = productName;
        Phone = phone;
        Line1 = line1;
        Line2 = line2;
        TotalPrice = totalPrice;
        this.payment = payment;
    }

    public int getBillID() {
        return BillID;
    }

    public void setBillID(int billID) {
        BillID = billID;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getLine1() {
        return Line1;
    }

    public void setLine1(String line1) {
        Line1 = line1;
    }

    public String getLine2() {
        return Line2;
    }

    public void setLine2(String line2) {
        Line2 = line2;
    }

    public int getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        TotalPrice = totalPrice;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}
