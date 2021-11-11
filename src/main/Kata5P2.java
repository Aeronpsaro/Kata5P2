package main;

import java.util.List;
import model.Histogram;
import model.Mail;
import view.HistogramDisplay;
import view.MailHistogramBuilder;
import view.MailListReader;

public class Kata5P2 {
    private List<Mail> mailList;
    private Histogram<String> histogram;
    private HistogramDisplay histoDisplay;
    
    private void execute() {
        input();
        process();
        output();
    }
    
    private void input() {
        mailList = MailListReader.read("email.txt");
    }
    
    private void process() {
        histogram = MailHistogramBuilder.build(mailList);
    }
        
    private void output() {
        histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
    
    public static void main(String[] args) {
        Kata5P2 instance = new Kata5P2();
        instance.execute();
    }
    
}
