package ui;

import model.Event;
import model.EventLog;

public class ConsoleLogPrinter {

    public static void printLog(EventLog el) {
        for (Event next : el) {
            System.out.println("\t" + next.toString() + "\n\n");
        }


    }

}
