package com.semestr.firstsemestrovka2kurs.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static boolean validateEmail(String email){
        Pattern p = Pattern.compile("([A-Za-z0-9][A-Za-z0-9-_.+!()]+)@([A-Za-z.]+)\\.([a-z]+)");
        Matcher m = p.matcher(email);
        return m.matches();
    }

    public static boolean validatePassword(String password){
        Pattern p = Pattern.compile("([^\\s]*[A-Za-z0-9!]+[^\\s]*)");
        Matcher m = p.matcher(password);
        return m.matches();
    }
}
