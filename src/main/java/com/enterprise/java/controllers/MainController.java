package com.enterprise.java.controllers;

import com.enterprise.java.models.Book;
import com.enterprise.java.models.Review;
import com.enterprise.java.services.BookService;
import com.enterprise.java.services.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    private BookService bookService;
    private ReviewService reviewService;

    public MainController(BookService bookService, ReviewService reviewService) {
        this.bookService = bookService;
        this.reviewService = reviewService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "index";
    }

    @GetMapping("/addbook")
    public String getAddBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }
    @PostMapping("/addbook")
    public String postAddBook(@ModelAttribute("book") Book book) {
        bookService.createOrUpdateBook(book);
        return "redirect:/";
    }

    @GetMapping("/addreview/{bookId}")
    public String getAddReview(@PathVariable int bookId, Model model) {
        model.addAttribute("bookId", bookId);
        model.addAttribute("review", new Review());
        return "addreview";
    }
    @PostMapping("/addreview")
    public String postAddReview(@ModelAttribute("review") Review review) {
        reviewService.createOrUpdateReview(review);
        return "redirect:/";
    }

}
