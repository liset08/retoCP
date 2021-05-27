package com.cayhualla.ecommerce_cineplanet.model;

import com.cayhualla.ecommerce_cineplanet.model.payu.Items;

import java.util.List;

public class CandyStore {

    private List<Items> items;
    public List<Items> getItem() {
        return items;
    }

    public void setItem(List<Items> item) {
        this.items = item;
    }


}