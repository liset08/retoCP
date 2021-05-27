package com.cayhualla.ecommerce_cineplanet.model.payu;

public class Items {

    private String price;
    private String description;
    private String name;
    private String unit;

    public Items(String price, String description, String name, String unit) {
        this.price = price;
        this.description = description;
        this.name = name;
        this.unit = unit;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Items{" +
                "price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }


}
