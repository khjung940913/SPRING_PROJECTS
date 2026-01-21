package guru.springframework.spring_6_webapp.services;

import guru.springframework.spring_6_webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
