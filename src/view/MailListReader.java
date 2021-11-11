package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Mail;

public class MailListReader {
    public static List<Mail> read(String filename) {
        String mailPattern = "[^@]+@[^@]+.[^@]+";
        List<Mail> mailList = new ArrayList<>();
        File file = new File(filename);
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String lineToTest = reader.nextLine();
                if (lineToTest.matches(mailPattern)) {
                    Mail newMail = new Mail(lineToTest);
                    mailList.add(newMail);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MailListReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mailList;
    }
}
