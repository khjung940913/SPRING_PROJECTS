package guru.springframework.spring_6_webapp.controllers;

import guru.springframework.spring_6_webapp.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // SPRING MVC - thymeleaf
    @RequestMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookService.findAll()); // passing books as "books" found in DB to the model that the VIEW can use
        return "books"; // return the VIEW named books.html under resources/templates
    }
}
