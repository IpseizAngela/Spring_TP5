package com.masteril.librairie.view;


import com.masteril.librairie.model.AskManager;
import com.masteril.librairie.model.BookManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {
    private JButton searchBook;
    private JButton deleteBook;
    private JButton updateBook;
    private JButton addBook;
    private JButton printAllBook;
    public JPanel panel;

    private BookManager manager;

    public Home(BookManager manager) {
        this.manager = manager;

        addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.printAddBook();
            }
        });
        printAllBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.searchBooks();
            }
        });
        searchBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.askTitle(AskManager.SEARCH);
            }
        });
        updateBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.askTitle(AskManager.UPDATE);
            }
        });
        deleteBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.askTitle(AskManager.DELETE);
            }
        });
    }



}
