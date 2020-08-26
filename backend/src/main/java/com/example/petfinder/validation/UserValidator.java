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
//    String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$";
//    Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
//    return pattern.matcher(email).find();
    Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(email);
    return matcher.find();

}
}
