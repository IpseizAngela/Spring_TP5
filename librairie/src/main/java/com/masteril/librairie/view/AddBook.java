package com.masteril.librairie.view;

import com.masteril.librairie.model.BookManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBook {

    private JTextField title;
    private JTextField author;
    private JTextField description;
    private JTextField price;
    private JButton add;
    public JPanel panel;
    private JButton accueilButton;

    public AddBook(BookManager manager) {

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String t = title.getText();
                String a = author.getText();
                String d = description.getText();
                String p = price.getText();
                reset();
                manager.addBook(t, a, d, p);
            }
        });
        accueilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
                manager.goToHome();
            }
        });
    }

    private void reset() {
        title.setText("");
        author.setText("");
        description.setText("");
        price.setText("");
    }
}
