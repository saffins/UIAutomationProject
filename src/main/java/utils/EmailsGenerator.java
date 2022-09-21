package utils;

import java.io.*;
import java.util.Random;

public class EmailsGenerator {


    private static final String FILE_PATH = "mailid.txt";
    private static final String MAIL_PATTERN = "saffin@gmail.com:";

    public static String getNextEmail() {
        int index = 0;
        String mail = null;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line = br.readLine();


            String[] mailArr = line.split(":");
            mail = mailArr[0];
            index = Integer.parseInt(mailArr[1]);

            int atIndex = mail.indexOf("@");
            mail = mail.substring(0, atIndex) + ++index + mail.substring(atIndex);
        } catch (IOException e) {
            // logger
        }

        try (PrintWriter writer = new PrintWriter(FILE_PATH, "UTF-8")) {
            writer.println(MAIL_PATTERN + index);
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            // logger
        }

        return mail;
    }


    public static String getCurrentEmail() {

        int index = 0;
        String email = null;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

            String line = br.readLine();
            String[] mailArr = line.split(":");
            email = mailArr[0];


        } catch (IOException e) {
            // logger
        }

        return email;
    }

    public static String getRandomEmail() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        return "usetoptttt" + randomInt + "@gmail.com";
    }
}
