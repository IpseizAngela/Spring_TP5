package com.masteril.librairie.view;

import com.masteril.librairie.model.BookManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateBook {

    private JTextField title;
    private JTextField author;
    private JTextField description;
    private JTextField price;
    private JButton update;
    public JPanel panel;
    private JButton acceuilButton;
    private int id;

    public UpdateBook(BookManager manager) {

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.updateBook(id, title.getText(), author.getText(), description.getText(), price.getText());
            }
        });
        acceuilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.goToHome();
            }
        });
    }

    public void setAttribut(int id, String title, String author, String description, String price) {
        this.id = id;
        this.title.setText(title);
        this.author.setText(author);
        this.description.setText(description);
        this.price.setText(price);
    }
}
