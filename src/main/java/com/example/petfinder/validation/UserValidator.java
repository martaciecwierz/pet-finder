package com.example.petfinder.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {

public static boolean isPasswordValid(String password){
    return password.length() >= 8;
}

public static boolean isFirstNameValid(String firstName){
    return firstName.length() >= 2;
}

public static boolean isLastNameValid(String lastName){
    return lastName.length() >=2;
}

public static boolean isEmailValid(String email){
    String regex = "^[a-zA-Z0-9_+&*-]+(?:\\\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,7}$";
    Pattern pattern = Pattern.compile(regex);
    return pattern.matcher(email).matches();
}
}
