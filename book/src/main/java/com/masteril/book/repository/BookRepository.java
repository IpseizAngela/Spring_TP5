package com.masteril.book.repository;

import com.masteril.book.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Integer> {

    Iterable<Book> findByAuthor(String author);
    Book findByTitle(String title);
    Book findById(int id);
    void deleteById(int id);

}
