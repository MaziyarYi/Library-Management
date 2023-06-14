package com.example.librarymanagement.daoRepository;

import javax.persistence.EntityManager;
import java.util.Objects;

public class BookDAO {

    private static BookDAO bookDAO;
    private EntityManager entity;

    private BookDAO() {
    }

    public static BookDAO getInstance() {
        if (Objects.isNull(bookDAO)) {
            bookDAO = new BookDAO();
        }
        return bookDAO;
    }
}
