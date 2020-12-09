package com.masteril.librairie;

import com.masteril.librairie.model.BookManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibrairieApplication {


    public static void main(String[] args) {
        BookManager manager = new BookManager();
    }

}
