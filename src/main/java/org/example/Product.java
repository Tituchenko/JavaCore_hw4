package org.example;
/**
 * Написать классы товар (название, цена)
 */

public class Product {
    private String name;
    private float price;

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }
}
