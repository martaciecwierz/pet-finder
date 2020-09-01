package com.example.petfinder.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputDataValidator {

    private static final String EMAIL_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    private static final String POST_CODE_REGEX = "^\\d{2}[-]\\d{3}$";
    private static final String PHONE_REGEX = "^\\d{8-13}$";

    public static boolean isPasswordValid(String password) {
        return password.length() >= 8;
    }

    public static boolean isFirstNameValid(String firstName) {
        return firstName.length() >= 2;
    }

    public static boolean isLastNameValid(String lastName) {
        return lastName.length() >= 2;
    }

    public static boolean isLengthValid(String str, int minLength) {
        return str.length() >= minLength;
    }

    public static boolean isEmailValid(String email) {
        return regexMatcher(email, EMAIL_REGEX);
    }

    public static boolean isPostCodeValid(String postCode) {
        return regexMatcher(postCode, POST_CODE_REGEX);
    }

    public static boolean isPhoneNumberValid(String phoneNumber) {
        return regexMatcher(phoneNumber, PHONE_REGEX);
    }

    private static boolean regexMatcher(String str, String regex) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }
}
