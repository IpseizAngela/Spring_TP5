package com.masteril.librairie.model;

import com.masteril.librairie.view.*;
import com.masteril.librairie.service.HTTPRequest;
import com.masteril.librairie.view.Error;


import javax.swing.*;

public class BookManager {



    private static JFrame frame;

    private static Home home;
    private static PrintBooks books;
    private static AddBook add;
    private static UpdateBook update;
    private static AskTitle askTitle;
    private static Error error;

    private int askForWhat;

    private static HTTPRequest request;

    public BookManager() {
        home = new Home(this);
        books = new PrintBooks(this);
        add = new AddBook(this);
        update = new UpdateBook(this);
        askTitle = new AskTitle(this);
        error = new Error(this);

        askForWhat = AskManager.ANY;
        request = new HTTPRequest();

        frame = new JFrame("Librairie");
        frame.setContentPane(home.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(700,500);
        frame.setVisible(true);
    }

    public void printAddBook() {
        frame.setVisible(false);
        frame.setContentPane(add.panel);
        frame.setVisible(true);
    }

    public void addBook(String title, String author, String description, String price) {
        double dPrice = 0;
        try {
            dPrice = Double.parseDouble(price);
        } catch(Exception ignored) {}
        request.addBook(title, author, description, dPrice);

        frame.setVisible(false);
        frame.setContentPane(home.panel);
        frame.setVisible(true);
    }

    public void searchBooks() {
        String list = request.getAllBooks();
        printViewAllBook(list);
    }

    public void printViewAllBook(String list) {
        frame.setVisible(false);
        books.setBooks(list);
        frame.setContentPane(books.panel);
        frame.setVisible(true);
    }

    public void goToHome() {
        frame.setVisible(false);
        frame.setContentPane(home.panel);
        frame.setVisible(true);
    }

    public void askTitle(int action) {
        frame.setVisible(false);
        frame.setContentPane(askTitle.panel);
        askForWhat = action;
        if (askForWhat == AskManager.SEARCH) askTitle.setScreen("Rechercher un livre", "Rechercher");
        else if (askForWhat == AskManager.UPDATE) askTitle.setScreen("Livre à modifier", "Suivant");
        else if (askForWhat == AskManager.DELETE) askTitle.setScreen("Livre à supprimer", "Supprimer");
        frame.setVisible(true);
    }

    public void next(String title) {
        int ask = askForWhat;
        askForWhat = AskManager.ANY;
        if (ask == AskManager.SEARCH) searchBook(title);
        else if (ask == AskManager.UPDATE) printUpdate(title);
        else if (ask == AskManager.DELETE) deleteBook(title);
        else goToHome();
    }

    public void searchBook(String title) {
        String books = request.getBook(title);
        printViewAllBook(books);
    }

    public void printUpdate(String title) {
        frame.setVisible(false);
        frame.setContentPane(update.panel);
        String json = request.getBookJSON(title);
        int id = Parser.getId(json);
        String author = Parser.getAuthor(json);
        String description = Parser.getDescription(json);
        String price = Parser.getPrice(json);
        if (id < 0)  frame.setContentPane(error.panel);
        else update.setAttribut(id, title, author, description, price);
        frame.setVisible(true);
    }

    public void updateBook(int id,String title, String author, String description, String price) {
        double dPrice = 0;
        try {
            dPrice = Double.parseDouble(price);
        } catch(Exception ignored) {}
        request.updateBook(id, title, author, description, dPrice);

        frame.setVisible(false);
        frame.setContentPane(home.panel);
        frame.setVisible(true);
    }

    public void deleteBook(String title) {
        request.deleteBook(title);

        frame.setVisible(false);
        frame.setContentPane(home.panel);
        frame.setVisible(true);
    }

}
