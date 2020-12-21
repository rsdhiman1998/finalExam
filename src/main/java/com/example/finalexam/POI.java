package com.example.finalexam;

public class POI {
    String p_name;
    String p_image;
    Double p_price;
    String c_name;
    String c_image;
    String countryName;

    public POI(String p_name, String p_image, Double p_price, String c_name, String c_image, String countryName) {
        this.p_name = p_name;
        this.p_image = p_image;
        this.p_price = p_price;
        this.c_name = c_name;
        this.c_image = c_image;
        this.countryName = countryName;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_image() {
        return p_image;
    }

    public void setP_image(String p_image) {
        this.p_image = p_image;
    }

    public Double getP_price() {
        return p_price;
    }

    public void setP_price(Double p_price) {
        this.p_price = p_price;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_image() {
        return c_image;
    }

    public void setC_image(String c_image) {
        this.c_image = c_image;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
