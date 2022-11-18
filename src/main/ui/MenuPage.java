package ui;

import model.KeyWordCipher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPage extends JFrame implements ActionListener {
    JLabel menuLabel;
    JButton end;
    JRadioButton hillCipher;
    JRadioButton subCipher;
    JRadioButton polyCipher;
    JRadioButton polyDeCipher;
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

        hillCipher = new JRadioButton("Hill Cipher");
        subCipher = new JRadioButton("Substitution Cipher");
        polyCipher = new JRadioButton("PolyAlphabetic Cipher");
        polyDeCipher = new JRadioButton("PolyAlphabetic Decipher!");
        keyCipher = new JRadioButton("KeyWord Cipher");
        loadData = new JRadioButton("Load data");
        saveData = new JRadioButton("Save data");



        ButtonGroup group = new ButtonGroup();
        group.add(hillCipher);
        group.add(subCipher);
        group.add(polyCipher);
        group.add(polyDeCipher);
        group.add(keyCipher);
        group.add(loadData);
        group.add(saveData);

        hillCipher.addActionListener(this);
        subCipher.addActionListener(this);
        polyCipher.addActionListener(this);
        polyDeCipher.addActionListener(this);
        keyCipher.addActionListener(this);
        loadData.addActionListener(this);

        add(hillCipher);
        add(subCipher);
        add(polyCipher);
        add(polyDeCipher);
        add(keyCipher);
        add(loadData);
        add(saveData);

        //pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == hillCipher) {
            System.out.println("!!!!!!!!!!");
            new HillCipherGraphics();
        }
        if (e.getSource() == subCipher) {
            new SubCipherGraphics();
        }
        if (e.getSource() == polyDeCipher) {
            System.out.println("!!!!!!!!!!");
            new PolyDeCipherGraphics();
        }
        if (e.getSource() == polyCipher) {
            new PolyCipherGraphics();
        }
        if (e.getSource() == keyCipher) {
            new KeyCipherGraphics();
        }
        if (e.getSource() == loadData) {
            System.out.println("loading data");
        }

    }
}
