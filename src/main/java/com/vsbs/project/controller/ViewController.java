package com.vsbs.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/book")
    public String bookPage() {
        return "book";
    }

    @GetMapping("/status")
    public String statusPage() {
        return "status";
    }
}

