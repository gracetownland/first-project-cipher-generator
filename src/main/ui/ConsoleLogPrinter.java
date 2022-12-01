package ui;

import model.Event;
import model.EventLog;

public class ConsoleLogPrinter {

    public static void printLog(EventLog el) {
        for (Event next : el) {
            if (next.toString().isEmpty()) {
                System.out.println("Nothting logged");
                break;
            }
            System.out.println("\t" + next.toString() + "\n\n");
        }


    }

}
