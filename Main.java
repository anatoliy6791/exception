package ru.skypro;

public class Main {

    public static void main(String[] args) {
        boolean result = Person.check("qwerty", "D_1hWiKjjP_9","D_1hWiKjjP_9");
        if (result) {
            System.out.println("Все верно");
        } else {
            System.out.println("логин или пароль не соответствуют требованиям!");
        }
    }
}

