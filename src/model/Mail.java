package model;

public class Mail {
    private String mail;
    
    public Mail(String newMail) {
        mail = newMail;
    }
    
    public String getDomain() {
        return mail.split("@")[1];
    }
}
