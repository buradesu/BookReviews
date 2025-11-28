package com.enterprise.java.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("books", book)
        return "index";
    }

    @RequestMapping("/addbook")
    public String addBook(Model model) {
        return "addbook";
    }

}
