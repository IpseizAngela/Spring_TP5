package com.masteril.book.dao;

import com.masteril.book.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAO implements IBookDAO {

    private List<Book> books;

    @Autowired
    public BookDAO() {
        init();
    }

    public void init() {
//        books = new ArrayList<>();
//        Book b = new Book(0);
//        b.setName("Vague de chaleur");
//        b.setAuthor("Richard Castle");
//        b.setDescription("Un magnat de l'immobilier est retrouvé mort au pied de son immeuble de Manhattan. " +
//                        "Et visiblement, il a eu de l'aide pour passer par-dessus la rambarde. Une femme avec un passé " +
//                        "trouble réchappe de justesse d'une embuscade. Il faut chaud, trop chaud, à New York et les " +
//                        "passions semblent se déchaîner. Quand un autre meurtre a lieu dans l'entourage de l'homme " +
//                        "d'affaires assassiné, la police enquête en eaux troubles, là où le secret et le silence font" +
//                        " loi.Mais l'enquêtrice de choc Nikki Heat est là pour faire la lumière sur cette sale affaire. " +
//                        "Avec son équipe, elle va percer un à un tous les secrets du mort, flambeur incestueux aux " +
//                        "multiples ennemis. Des secrets que de nombreuses personnes auraient préféré laisser dans l'ombre.");
//        b.setPrice(8.20);
//
//        books.add(b);
    }
    
    @Override
    public List<Book> findAll() {
        return getBooks();
    }

    @Override
    public Book findById(int id) {
        Book book = null;
        int index = 0; boolean find = false;
        while(index < books.size() && !find) {
            if (books.get(index).getId() == id) {
                book = books.get(index);
                find = true;
            }
            index++;
        }
        return book;
    }

    @Override
    public void save(Book b) {
        boolean add = true;
        for(Book book : books) {
            if (book.getId() == b.getId()) add = false;
        }
        if (add) books.add(b);
    }

    @Override
    public void update(Book newBook, int id) {
        Book book = findById(id);
        if (newBook.getAuthor() != null) book.setAuthor(newBook.getAuthor());
        if (newBook.getTitle() != null) book.setTitle(newBook.getTitle());
        if (newBook.getDescription() != null)book.setDescription(newBook.getDescription());
        if (newBook.getPrice() >= 0)book.setPrice(newBook.getPrice());
    }

    @Override
    public void delete(int id) {
        Book book = findById(id);
        books.remove(book);
    }

    public List<Book> getBooks() {
        return books;
    }

}
