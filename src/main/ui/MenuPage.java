package ui;

import model.KeyWordCipher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPage extends JFrame implements ActionListener {
    JLabel menuLabel;
    JButton end;
    JRadioButton subCipher;
    JRadioButton polyCipher;
    JRadioButton keyCipher;
    JRadioButton loadData;
    JRadioButton saveData;



    public MenuPage() {
        end = new JButton();
        end.setBounds(700, 450, 50, 20);
        end.addActionListener(e -> System.exit(0));
        end.setText("Exit");


        menuLabel = new JLabel();
        menuLabel.setText("Press the desired option.");
        menuLabel.setBounds(200, 0, 500, 50);
        menuLabel.setVerticalAlignment(JLabel.TOP);
        menuLabel.setHorizontalAlignment(JLabel.CENTER);
        menuLabel.setVisible(true);

        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        add(menuLabel);
        add(end);
        setLayout(new FlowLayout());

        subCipher = new JRadioButton("Substitution Cipher");
        polyCipher = new JRadioButton("PolyAlphabetic Cipher");
        keyCipher = new JRadioButton("KeyWord Cipher");
        loadData = new JRadioButton("Load data");



        ButtonGroup group = new ButtonGroup();
        group.add(subCipher);
        group.add(polyCipher);
        group.add(keyCipher);
        group.add(loadData);

        subCipher.addActionListener(this);
        polyCipher.addActionListener(this);
        keyCipher.addActionListener(this);
        loadData.addActionListener(this);

        add(subCipher);
        add(polyCipher);
        add(keyCipher);
        add(loadData);

        //pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == subCipher) {
            System.out.println("substitution cipher ");
            new SubCipherGraphics();
        }
        if (e.getSource() == polyCipher) {
            System.out.println("polyalphabetic cipher");
            new PolyCipherGraphics();
        }
        if (e.getSource() == keyCipher) {
            System.out.println("Key word cipher");
            new KeyWordCipher();
        }
        if (e.getSource() == loadData) {
            System.out.println("loading data");
        }
    }
}
