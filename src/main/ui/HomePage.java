package ui;

import model.EventLog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame implements ActionListener {
    JButton button;
    JButton end;
    JLabel label;

    public HomePage() {

        makeEndButton();
        makeStartButton();
        makeCipherLabel();
        addAllComponents();
        init();
    }

    public void makeEndButton() {
        end = new JButton();
        end.setBounds(700, 450, 50, 20);
        end.addActionListener(e -> System.exit(0));
        end.setText("Exit");
    }

    public void makeStartButton() {
        button = new JButton();
        button.setBounds(350, 250, 100, 60);
        button.setFocusable(false);
        button.setText("Start!");
        button.addActionListener(this);
        button.setFont(new Font("Comic Sans MS", Font.ITALIC, 25));

    }

    public void makeCipherLabel() {
        label = new JLabel();
        label.setText("Welcome to the Cipher Text Generator");
        label.setBounds(200, 0, 500, 50);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVisible(true);
    }

    public void addAllComponents() {
        add(label);
        add(button);
        add(end);

    }

    public void init() {
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            this.dispose();
            System.out.println("this works.");
            new MenuPage();
        }
        if (e.getSource() == end) {
            System.out.println("EVENT LOG");
            ConsoleLogPrinter.printLog(EventLog.getInstance());
        }
    }

    public static void main(String[] args) {
        new HomePage();
    }
}
