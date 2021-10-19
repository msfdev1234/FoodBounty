package com.madmobiledevs.foodbounty.Model;

public class Restaurants {

    public String name, photo, details, address, discount, menu_img, description, couponCode;

    public Restaurants() {
    }

    public Restaurants(String name, String photo, String details, String address, String discount, String menu_img, String description, String couponCode) {
        this.name = name;
        this.photo = photo;
        this.details = details;
        this.address = address;
        this.discount = discount;
        this.menu_img = menu_img;
        this.description = description;
        this.couponCode = couponCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getMenu_img() {
        return menu_img;
    }

    public void setMenu_img(String menu_img) {
        this.menu_img = menu_img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }
}
