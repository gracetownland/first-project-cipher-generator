package ui;

import model.SuperCipher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PolyDeCipherGraphics extends MenuPage implements ActionListener {
    JFrame polyFrame;
    JLabel heading;
    JLabel acceptInputMessage;
    JLabel acceptKeyWordMessage;
    JLabel outputMessage;
    JTextField acceptInput;
    JTextField keyWord;
    JButton submit;
    SuperCipher superCipher;

    public PolyDeCipherGraphics() {
        polyFrame = new JFrame();
        superCipher = new SuperCipher();
        setSubmit();
        setAcceptInput();
        setMoveBy();
        setAcceptMoveByMessage();
        setHeading();
        setAcceptInputMessage();
        setOutputMessage();

        polyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addAll();
        polyFrame.setSize(800, 500);
        polyFrame.setLayout(null);
        polyFrame.setVisible(true);
        setVisible(false);

    }

    public void setAcceptInputMessage() {
        acceptInputMessage = new JLabel();
        acceptInputMessage.setText("Enter a sentence");
        acceptInputMessage.setBounds(200, 25, 500, 50);
    }

    public void setOutputMessage() {
        outputMessage = new JLabel();
        outputMessage.setVisible(false);
        outputMessage.setBounds(200, 150, 500, 30);

    }

    public void setAcceptMoveByMessage() {
        acceptKeyWordMessage = new JLabel();
        acceptKeyWordMessage.setText("Enter keyword");
        acceptKeyWordMessage.setBounds(200, 75, 500, 30);
    }

    public void setHeading() {
        heading = new JLabel();
        heading.setText("POLYALPHABETIC DECIPHER");
        heading.setBounds(200, 0, 500, 30);
        heading.setVerticalAlignment(JLabel.TOP);
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setVisible(true);
    }

    public void setMoveBy() {
        keyWord = new JTextField();
        keyWord.setPreferredSize(new Dimension(250, 40));
        keyWord.setBounds(200, 100, 500, 25);
    }

    public void setAcceptInput() {
        acceptInput = new JTextField();
        acceptInput.setPreferredSize(new Dimension(250, 40));
        acceptInput.setBounds(200, 50, 500, 25);
    }

    public void setSubmit() {
        submit = new JButton();
        submit.setText("Submit!");
        submit.addActionListener(this);
        submit.setBounds(90, 50, 100, 25);
    }

    public void addAll() {
        polyFrame.add(heading);
        polyFrame.add(acceptInputMessage);
        polyFrame.add(submit);
        polyFrame.add(acceptInput);
        polyFrame.add(keyWord);
        polyFrame.add(acceptKeyWordMessage);
        polyFrame.add(outputMessage);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String toBeEncrypted = acceptInput.getText().trim();
            MenuPage.addListInput(toBeEncrypted);
            String number = keyWord.getText().trim();
            int i = superCipher.addPolyCipher();
            superCipher.getPolyDeCipher(i).setAll(toBeEncrypted, number.toUpperCase());
            superCipher.getPolyDeCipher(i).keywordgenerator();
            MenuPage.addListOutput(superCipher.getPolyDeCipher(i).cipher());
            outputMessage.setText(superCipher.getPolyDeCipher(i).cipher());
            outputMessage.setVisible(true);

        }

    }
}
