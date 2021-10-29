package com.example.demo.model;

public class Nomenclature {

    private String code;
    private String description;
    private int price;

    public Nomenclature() {

    }

    public Nomenclature(String code, String description, int price) {
        this.code = code;
        this.description = description;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
