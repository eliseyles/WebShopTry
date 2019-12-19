package com.example.kyfar.validation;

import com.example.kyfar.exceptions.NullStringDataException;

public class Validation {
    public static boolean isValidTitle(String title) {
        if (title == null) {
            throw new NullStringDataException();
        }
        return title.length() > 3 && title.length() < 50;
    }

    public static boolean isValidDescription(String description) {
        if (description == null) {
            throw new NullStringDataException();
        }
        return description.length() > 5 && description.length() < 100;
    }

    public static boolean isValidPrice(String price) {
        if (price == null) {
            throw new NullStringDataException();
        }
        return price.matches("^[0-9]+(\\.[0-9]{2})?$");
    }
}
