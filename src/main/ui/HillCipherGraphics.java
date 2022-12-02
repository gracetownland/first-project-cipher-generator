package ui;

import model.SuperCipher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HillCipherGraphics extends MenuPage implements ActionListener {
    JFrame hillFrame;
    JLabel heading;
    JLabel acceptInputMessage;
    JLabel acceptMoveByMessage;
    JLabel outputMessage;
    JTextField acceptInput;
    JTextField moveBy;
    JButton submit;
    SuperCipher superCipher;

    public HillCipherGraphics() {
        hillFrame = new JFrame();
        superCipher = new SuperCipher();
        setSubmit();
        setAcceptInput();
        setMoveBy();
        setAcceptMoveByMessage();
        setHeading();
        setAcceptInputMessage();
        setOutputMessage();

        hillFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addAll();
        hillFrame.setSize(800, 500);
        hillFrame.setLayout(null);
        hillFrame.setVisible(true);
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
        acceptMoveByMessage = new JLabel();
        acceptMoveByMessage.setText("Enter keyword!");
        acceptMoveByMessage.setBounds(200, 75, 500, 30);
    }

    public void setHeading() {
        heading = new JLabel();
        heading.setText("HILL CIPHER");
        heading.setBounds(200, 0, 500, 30);
        heading.setVerticalAlignment(JLabel.TOP);
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setVisible(true);
    }

    public void setMoveBy() {
        moveBy = new JTextField();
        moveBy.setPreferredSize(new Dimension(250, 40));
        moveBy.setBounds(200, 100, 500, 25);
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
        hillFrame.add(heading);
        hillFrame.add(acceptInputMessage);
        hillFrame.add(submit);
        hillFrame.add(acceptInput);
        hillFrame.add(moveBy);
        hillFrame.add(acceptMoveByMessage);
        hillFrame.add(outputMessage);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            int i = superCipher.addHillCipher();
            String toBeEncrypted = acceptInput.getText();
            MenuPage.addListInput(toBeEncrypted);
            String number = moveBy.getText();
            superCipher.getHillCipher(i).setAll(toBeEncrypted, number);
            String result = superCipher.getHillCipher(i).cipher();
            MenuPage.addListOutput(result);
            outputMessage.setText(result);
            outputMessage.setVisible(true);

        }

    }
}
