package com.masteril.librairie.view;

import com.masteril.librairie.model.BookManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AskTitle {
    private JTextField title;
    private JButton next;
    public JPanel panel;
    private JLabel titleScreen;
    private JButton accueilButton;

    private BookManager manager;

    public AskTitle(BookManager manager) {
        this.manager = manager;

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String t = title.getText();
                title.setText("");
                manager.next(t);
            }
        });
        accueilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                title.setText("");
                manager.goToHome();
            }
        });
    }

    public void setScreen (String title, String button) {
        titleScreen.setText(title);
        next.setText(button);
    }
}
