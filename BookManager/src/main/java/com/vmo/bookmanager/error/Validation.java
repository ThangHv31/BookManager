package com.vmo.bookmanager.error;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static final String DATE_PATTERN = "\\d{2}-\\d{2}-\\d{4}";
    public static final String EMAIL_PATTERN = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,})$";
    public static final String PHONE_NUMBER_PATTERN = "\\d{10}";
    public static final String NUMBER_PATTERN = "[0-9]";

    public static boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean validatePhoneNumber(String number) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

    public static boolean validateNumber(String number) {
        Pattern pattern = Pattern.compile(NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

    public static boolean validateDate(String date) {
        Pattern pattern = Pattern.compile(DATE_PATTERN);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }
}
