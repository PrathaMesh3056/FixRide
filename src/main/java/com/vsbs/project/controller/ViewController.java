package com.vsbs.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String home() {
        return "index"; // renders templates/index.html
    }

    @GetMapping("/book")
    public String bookPage() {
        return "book"; // renders templates/book.html
    }

    @GetMapping("/status")
    public String statusPage() {
        return "status"; // renders templates/status.html
    }

    @GetMapping("/admin-dashboard")
    public String adminPage() {
        return "admin-dashboard"; // renders templates/admin-dashboard.html
    }
}
