package com.masteril.librairie.view;

import com.masteril.librairie.model.BookManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Error {
    public JPanel panel;
    private JButton accueilButton;

    public Error(BookManager manager) {
        accueilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.goToHome();
            }
        });
    }
}
