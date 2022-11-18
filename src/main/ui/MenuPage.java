package ui;

import model.KeyWordCipher;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuPage extends JFrame implements ActionListener {
    JLabel menuLabel;
    JLabel imageLabel;
    JButton end;
    JRadioButton hillCipher;
    JRadioButton subCipher;
    JRadioButton polyCipher;
    JRadioButton polyDeCipher;
    JRadioButton keyCipher;
    JRadioButton loadData;
    JRadioButton saveData;
    ButtonGroup group;
    JsonReader reader;
    JsonWriter writer;
    ImageIcon image;


    public MenuPage() {
        // ArrayList<String> listInput = reader.buildUserInput();
        //ArrayList<String> listOutput = reader.buildUserOutput();
        init();
        makeImageLabel();
        makeEndButton();
        makeMenuLabel();
        makeRadioButtons();
        addButtonGroups();
        addListeners();
        addAllComponents();
        //pack();
        setVisible(true);
    }

    public void init() {
        reader = new JsonReader("./data/data2.json");
        writer = new JsonWriter("./data/data2.json");
        setSize(400, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        image = new ImageIcon("src/main/ui/projectcipher.jpeg");
    }

    public void makeImageLabel() {
        imageLabel = new JLabel();
        imageLabel.setIcon(image);
        imageLabel.setBounds(200, 50, 200, 200);
        imageLabel.setOpaque(true);
        imageLabel.setVisible(true);
    }

    public void makeMenuLabel() {
        menuLabel = new JLabel();
        menuLabel.setText("Press the desired option: ");
        menuLabel.setBounds(200, 0, 500, 50);
        menuLabel.setVerticalAlignment(JLabel.TOP);
        menuLabel.setHorizontalAlignment(JLabel.CENTER);
        menuLabel.setVisible(true);
    }

    public void makeRadioButtons() {
        hillCipher = new JRadioButton("Hill Cipher");
        subCipher = new JRadioButton("Substitution Cipher");
        polyCipher = new JRadioButton("PolyAlphabetic Cipher");
        polyDeCipher = new JRadioButton("PolyAlphabetic Decipher!");
        keyCipher = new JRadioButton("KeyWord Cipher");
        loadData = new JRadioButton("Load data");
        saveData = new JRadioButton("Save data");
    }

    public void addButtonGroups() {
        group = new ButtonGroup();
        group.add(hillCipher);
        group.add(subCipher);
        group.add(polyCipher);
        group.add(polyDeCipher);
        group.add(keyCipher);
        group.add(loadData);
        group.add(saveData);
    }

    public void addListeners() {
        hillCipher.addActionListener(this);
        subCipher.addActionListener(this);
        polyCipher.addActionListener(this);
        polyDeCipher.addActionListener(this);
        keyCipher.addActionListener(this);
        loadData.addActionListener(this);
    }

    public void addAllComponents() {
        add(menuLabel);
        add(imageLabel);
        add(hillCipher);
        add(subCipher);
        add(polyCipher);
        add(polyDeCipher);
        add(keyCipher);
        add(loadData);
        add(saveData);
        add(end);
    }

    public void makeEndButton() {
        end = new JButton();
        end.setBounds(700, 450, 50, 20);
        end.addActionListener(e -> System.exit(0));
        end.setText("Exit");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == hillCipher) {
            new HillCipherGraphics();
        }
        if (e.getSource() == subCipher) {
            new SubCipherGraphics();
        }
        if (e.getSource() == polyDeCipher) {
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
