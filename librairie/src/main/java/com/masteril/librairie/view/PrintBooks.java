package com.masteril.librairie.view;


import com.masteril.librairie.model.BookManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrintBooks {

    private JButton home;
    public JPanel panel;
    private JTextArea listBooks;

    private BookManager manager;

    public PrintBooks(BookManager manager) {
        this.manager = manager;

        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.goToHome();
            }
        });
    }

    public void setBooks(String books) {
        this.listBooks.setText(books);
    }
}
