package org.example;

public class ProductException extends RuntimeException{
    public ProductException (String name){
        super(String.format("Продукт %s не найден в массиве продуктов",name));
    }

}
