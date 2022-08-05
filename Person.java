package ru.skypro;

import java.util.Objects;

public class Person {

    private static final String VALID_SYMBOLS = "zxcvbnmasdfghjklqwertyuiopZXCVBNMASDFGHJKLQWERTYUIOP1234567890_";

    private Person() {

    }

    public static boolean check(String login,
                                String password,
                                String confirmPassword) {
        try {
            person(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static void person(String login,
                               String password,
                               String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (Objects.isNull(login) || login.length() > 20 || !containsPersonSymbols(login)) {
            throw new WrongLoginException("Логин  не может быть более 20 символов, содержит в себе только латинские буквы, цифры и знак подчеркивания ");
        }
        if (Objects.isNull(password) || password.length() >= 20 || !containsPersonSymbols(password) ||
                Objects.isNull(confirmPassword) || confirmPassword.length() >= 20 || !containsPersonSymbols(confirmPassword) ) {
            throw new WrongPasswordException("пароль должен быть менее 20 символов, содержит в себе только латинские буквы, цифры и знак подчеркивания ");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли должны совпадать");
        }
    }



    private static boolean containsPersonSymbols(String s) {
        char[] symbols = s.toCharArray();
        for (char symbol : symbols) {
                if (!VALID_SYMBOLS.contains(String.valueOf(symbol))) {
                    return false;
                }
            }
        return true;
    }
}

