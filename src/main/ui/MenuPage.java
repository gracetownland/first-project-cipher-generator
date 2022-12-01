package ui;

import model.EventLog;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuPage extends JFrame implements ActionListener {
    JPanel messages;
    // JLabel ioMessage;
    JLabel menuLabel;
    JLabel imageLabel;
    JLabel inputListLabel;
    JLabel outputListLabel;
    JButton end;
    JRadioButton hillCipher;
    JRadioButton subCipher;
    JRadioButton polyCipher;
    JRadioButton polyDeCipher;
    JRadioButton keyCipher;
    JRadioButton loadData;
    JRadioButton saveData;
    ButtonGroup group;
    JsonReader reader = new JsonReader("./data/data2.json");
    JsonWriter writer = new JsonWriter("./data/data2.json");
    static ArrayList<String> listInput;
    static ArrayList<String> listOutput;
    ImageIcon image;


    public MenuPage() {
        listInput = reader.buildUserInput();
        listOutput = reader.buildUserOutput();
        init();

        makeMessagesPanel();
        makeInputOutputListLabel();
        makeImageLabel();
        makeEndButton();
        makeMenuLabel();
        makeRadioButtons();
        addButtonGroups();
        addListeners();
        addAllComponents();
        setVisible(true);
    }

    public void makeMessagesPanel() {

        messages = new JPanel();
        messages.setVisible(true);
        messages.setPreferredSize(new Dimension(800, 100));
        messages.setOpaque(true);
        messages.setBackground(Color.CYAN);
        messages.setLayout(new BorderLayout());
    }

    public void makeInputOutputListLabel() {
//        ioMessage = new JLabel();
//        ioMessage.setText("TOP-INPUT. BOTTOM-OUTPUT.");
//        ioMessage.setVisible(false);
//        messages.add(ioMessage, BorderLayout.CENTER);
        inputListLabel = new JLabel();
        inputListLabel.setVisible(false);
        messages.add(inputListLabel, BorderLayout.NORTH);
        outputListLabel = new JLabel();
        outputListLabel.setVisible(false);
        messages.add(outputListLabel, BorderLayout.SOUTH);
    }

    public void init() {

        setSize(800, 800);
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
        saveData.addActionListener(this);
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
        add(messages);
    }

    public void makeEndButton() {
        end = new JButton();
        end.setBounds(700, 450, 50, 20);
        end.addActionListener(this);
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
        loadDataorSaveData(e);
        if (e.getSource() == end) {
            printEventLog();
        }

    }

    public void loadDataorSaveData(ActionEvent e) {
        if (e.getSource() == loadData) {
            displayData();
        }
        if (e.getSource() == saveData) {
            writer.write(listInput, listOutput);
        }
    }

    public void printEventLog() {
        System.out.println("EVENT LOG");
        ConsoleLogPrinter.printLog(EventLog.getInstance());
        System.exit(0);
    }

    public void displayData() {
        StringBuilder inputData = new StringBuilder();
        inputData.append("INPUT -> ");
        for (String s : listInput) {
            inputData.append(s == null ? "" : (s + ", "));
            inputListLabel.setText(inputData.toString());
            inputListLabel.setVisible(true);
        }
        StringBuilder outputData = new StringBuilder();
        outputData.append("OUTPUT -> ");
        for (String s : listOutput) {
            outputData.append(s == null ? "" : (s + ", "));
            outputListLabel.setText(outputData.toString());
            outputListLabel.setVisible(true);
        }
    }

    public ArrayList<String> getListInput() {
        return listInput;
    }

    public ArrayList<String> getListOutput() {
        return listOutput;
    }

    public static void addListInput(String toBeEncrypted) {
        listInput.add(toBeEncrypted);

    }

    public static void addListOutput(String cipher) {

        listOutput.add(cipher);
    }
}
