package com.example.kyfar.validation;

import com.example.kyfar.exceptions.NullStringDataException;

public class UserValidation {
        public static boolean isValidUsername(String username) {
        if (username == null) {
            throw new NullStringDataException();
        }
        return username.length() > 3 && username.length() < 20 && username.matches("[A-Za-z0-9_]+");
    }

    public static boolean isValidPassword(String username) {
        if (username == null) {
            throw new NullStringDataException();
        }
        return username.length() > 8 && username.length() < 30;
    }
}
