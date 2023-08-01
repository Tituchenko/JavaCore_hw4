package org.example;

/**
 * 1. Написать классы покупатель (ФИО, возраст, телефон)
 */
public class Buyer {
    private String fio;
    private int age;
    private String phone;

    public String getFio() {
        return fio;
    }

    public Buyer(String fio, int age, String phone) {
        this.fio = fio;
        this.age = age;
        this.phone = phone;
    }
}
