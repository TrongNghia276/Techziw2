package com.enoch.shoppersparadise.model;

public class Address {
    int addressId;
    int UserId;
    String Line1;
    String Line2;
    String Phone;
    String City;
    String Zipcode;
    String State;
    String Country;

    public Address() {
    }

    public Address(int addressId,int UserId, String line1, String line2, String phone, String city, String zipcode, String state, String country) {
        this.addressId = addressId;
        this.UserId = UserId;
        Line1 = line1;
        Line2 = line2;
        Phone = phone;
        City = city;
        Zipcode = zipcode;
        State = state;
        Country = country;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
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

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getZipcode() {
        return Zipcode;
    }

    public void setZipcode(String zipcode) {
        Zipcode = zipcode;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }
}
