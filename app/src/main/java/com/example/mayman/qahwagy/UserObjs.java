package com.example.mayman.qahwagy;

/**
 * Created by mahmo on 2/26/2018.
 */

public class UserObjs {
    String milk;
    String name;
    String quantity;
    String size;
    String sugar;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMilk() {
        return milk;
    }

    public void setMilk(String milk) {
        this.milk = milk;
    }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public UserObjs() {

    }

    public UserObjs(String name, String milk, String sugar, String quantity, String size) {

        this.name = name;
        this.milk = milk;
        this.sugar = sugar;
        this.quantity = quantity;
        this.size = size;
    }
}
