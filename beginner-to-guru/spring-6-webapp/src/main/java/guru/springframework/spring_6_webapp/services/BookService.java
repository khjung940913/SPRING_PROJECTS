package guru.springframework.spring_6_webapp.services;

import guru.springframework.spring_6_webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
