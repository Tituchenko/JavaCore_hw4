package org.example;

public class CustomerException extends RuntimeException{
    public CustomerException(String name) {
        super(String.format("Пользователь %s не найден в массиве пользователей",name));
    }
}
