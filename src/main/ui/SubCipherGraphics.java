package ui;

import model.SuperCipher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubCipherGraphics extends MenuPage implements ActionListener {
    JFrame subFrame;
    JLabel heading;
    JLabel acceptInputMessage;
    JLabel acceptMoveByMessage;
    JLabel outputMessage;
    JTextField acceptInput;
    JTextField moveBy;
    JButton submit;
    SuperCipher superCipher;

    public SubCipherGraphics() {
        subFrame = new JFrame();
        superCipher = new SuperCipher();
        setSubmit();
        setAcceptInput();
        setMoveBy();
        setAcceptMoveByMessage();
        setHeading();
        setAcceptInputMessage();
        setOutputMessage();

        subFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addAll();
        subFrame.setSize(800, 500);
        subFrame.setLayout(null);
        subFrame.setVisible(true);
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
        acceptMoveByMessage.setText("Enter how many digit's you want to move by!");
        acceptMoveByMessage.setBounds(200, 75, 500, 30);
    }

    public void setHeading() {
        heading = new JLabel();
        heading.setText("SUBSTITUTION CIPHER");
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
        subFrame.add(heading);
        subFrame.add(acceptInputMessage);
        subFrame.add(submit);
        subFrame.add(acceptInput);
        subFrame.add(moveBy);
        subFrame.add(acceptMoveByMessage);
        subFrame.add(outputMessage);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String toBeEncrypted = acceptInput.getText();
            String number = moveBy.getText();
            superCipher.getSubCipher().setAll(toBeEncrypted, number);
            System.out.println(superCipher.getSubCipher().cipher());
            outputMessage.setText(superCipher.getSubCipher().cipher());
            outputMessage.setVisible(true);

        }

    }
}
