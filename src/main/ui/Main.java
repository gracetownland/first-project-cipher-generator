package ui;

import model.EventLog;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type in GUI for Graphical User Interface or CUI for Console Interface ");
        String choice = sc.next();
        if (choice.equals("CUI")) {
            new CipherTextGenerator();
        } else if (choice.equalsIgnoreCase("GUI")) {
            new HomePage();
        }
        System.out.println("EVENT LOG");
        ConsoleLogPrinter.printLog(EventLog.getInstance());

    }
}
