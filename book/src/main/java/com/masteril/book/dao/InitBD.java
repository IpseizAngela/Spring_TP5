package com.masteril.book.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

@Component
public class InitBD implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Création et initialisation de la base de données.");

        String sqlStatements[] = {
                "drop table book if exists",
                "create table book(" +
                        "id serial, " +
                        "title varchar(255), " +
                        "author varchar(255), " +
                        "description varchar(max), " +
                        "price double, " +
                        "constraint title_unique unique (title)" +
                ")",
                "INSERT INTO Book (title, author, description, price) VALUES ('Harry Potter', 'J. K. Rowling', 'Tout le monde connait ce livre', 6.80);",
                "INSERT INTO Book (title, author, description, price) VALUES ('Vague de chaleur', 'Richard Castle', 'Un livre policier plein de suspens mais également de romance', 8.20);",
                "INSERT INTO Book (title, author, description, price) VALUES ('Le petit prince', 'Antoine de Saint Exupery', 'Une histoire racontant les incroyables aventures du petit prince.', 6.00);"
        };

        Arrays.asList(sqlStatements).stream().forEach(sql -> {
            System.out.println(sql);
            jdbcTemplate.execute(sql);
        });

        System.out.println("Affichage de tous les livres ------------");
        jdbcTemplate.query("select * from book",
                new RowMapper<Object>() {

                    @Override
                    public Object mapRow(ResultSet book, int i) throws SQLException {
                        System.out.println("id : " + book.getString("id")
                                        + ", titre : " + book.getString("title")
                                        + ", auteur : " + book.getString("author")
                                        + ", description : " + book.getString("description")
                                        + ", prix : " + book.getDouble("price") + "€.");
                        return null;
                    }

                });

    }
}
