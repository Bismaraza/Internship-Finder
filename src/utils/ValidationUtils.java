package utils;

public class ValidationUtils {
    public static boolean isValidEmail(String email){
        return email.contains("@") && email.contains(".");
    }
}
