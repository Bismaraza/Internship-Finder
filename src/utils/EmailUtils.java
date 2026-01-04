package utils;

public class EmailUtils {
    public static void sendEmail(String to, String subject, String body){
        System.out.println("Sending email to " + to + ": " + subject);
    }
}
