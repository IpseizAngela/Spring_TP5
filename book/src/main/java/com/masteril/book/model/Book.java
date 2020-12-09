package com.masteril.book.model;

import javax.persistence.*;

@Entity
@Table(name = "BOOK")
public class Book {

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private int id;

        @Column(name = "title", unique = true)
        private String title;

        @Column(name = "author")
        private String author;

        @Column(name = "description")
        private String description;

        @Column(name = "price")
        private double price;

        public Book(int id, String title, String author, String description, double price) {
                this.id = id;
                this.title = title;
                this.author = author;
                this.description = description;
                this.price = price;
        }

        public Book() {

        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getAuthor() {
                return author;
        }

        public void setAuthor(String author) {
                this.author = author;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public double getPrice() {
                return price;
        }

        public void setPrice(double price) {
                this.price = price;
        }
}
