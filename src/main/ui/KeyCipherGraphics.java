package ui;

import model.SuperCipher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeyCipherGraphics extends MenuPage implements ActionListener {
    JFrame keyFrame;
    JLabel heading;
    JLabel acceptInputMessage;
    JLabel acceptKeyWordMessage;
    JLabel outputMessage;
    JTextField acceptInput;
    JTextField keyWord;
    JButton submit;
    SuperCipher superCipher;

    public KeyCipherGraphics() {
        keyFrame = new JFrame();
        superCipher = new SuperCipher();
        setSubmit();
        setAcceptInput();
        setMoveBy();
        setAcceptMoveByMessage();
        setHeading();
        setAcceptInputMessage();
        setOutputMessage();

        keyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addAll();
        keyFrame.setSize(800, 500);
        keyFrame.setLayout(null);
        keyFrame.setVisible(true);
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
        outputMessage.setBounds(200,150,500,30);

    }

    public void setAcceptMoveByMessage() {
        acceptKeyWordMessage = new JLabel();
        acceptKeyWordMessage.setText("Enter keyword!");
        acceptKeyWordMessage.setBounds(200, 75, 500, 30);
    }

    public void setHeading() {
        heading = new JLabel();
        heading.setText("KEYWORD CIPHER");
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
        keyFrame.add(heading);
        keyFrame.add(acceptInputMessage);
        keyFrame.add(submit);
        keyFrame.add(acceptInput);
        keyFrame.add(keyWord);
        keyFrame.add(acceptKeyWordMessage);
        keyFrame.add(outputMessage);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            int i = superCipher.addKeyCipher();
            String toBeEncrypted = acceptInput.getText();
            MenuPage.addListInput(toBeEncrypted);
            String number = keyWord.getText();
            superCipher.getKeyCipher(i).setAll(toBeEncrypted, number);
            MenuPage.addListOutput(superCipher.getKeyCipher(i).cipher());
            outputMessage.setText(superCipher.getKeyCipher(i).cipher());
            outputMessage.setVisible(true);

        }

    }
}
