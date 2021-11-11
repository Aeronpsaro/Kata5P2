package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Mail;

public class MailListReaderBD {
    public static List<Mail> read(String filename) {
        String mailPattern = "[^@]+@[^@]+.[^@]+";
        List<Mail> mailList = new ArrayList<>();
        
        Connection db = null;
        String url = "jdbc:sqlite:KATA5.db";
        try {
            db = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
        }
        
        String sql = "SELECT * FROM EMAIL";
        
        try {
            Statement stmt = db.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                String lineToTest = rs.getString("Mail");
                if (lineToTest.matches(mailPattern)) {
                    Mail newMail = new Mail(lineToTest);
                    mailList.add(newMail);
                }
            }
        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
        } finally {
            if (db != null) {
                try {
                    db.close();
                } catch (SQLException ex) {
                    System.out.println("" + ex.getMessage());
                }
            }
        }
        
        return mailList;
    }
}
