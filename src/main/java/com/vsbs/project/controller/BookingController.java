package com.vsbs.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vsbs.project.entities.Booking;
import com.vsbs.project.service.BookingService;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Handles JSON payload from AJAX/Fetch API
    @PostMapping(value = "/book", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Booking> bookServiceJson(@RequestBody Booking booking) {
        Booking saved = bookingService.bookService(booking);
        return ResponseEntity.ok(saved);
    }

    // Handles standard form submission (application/x-www-form-urlencoded)
    @PostMapping(value = "/book", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<Booking> bookServiceForm(@ModelAttribute Booking booking) {
        Booking saved = bookingService.bookService(booking);
        return ResponseEntity.ok(saved);
    }

    // Fallback general book endpoint
    @PostMapping("/book")
    public ResponseEntity<Booking> bookService(@RequestBody(required = false) Booking booking) {
        if (booking == null) {
            return ResponseEntity.badRequest().build();
        }
        Booking saved = bookingService.bookService(booking);
        return ResponseEntity.ok(saved);
    }

    // Handles both /mybookings and /mybookings/ with param 'name' or 'customerName'
    @GetMapping({"/mybookings", "/mybookings/"})
    public ResponseEntity<List<Booking>> getBookings(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "customerName", required = false) String customerName) {
        String query = (customerName != null && !customerName.trim().isEmpty()) ? customerName : name;
        if (query == null || query.trim().isEmpty()) {
            return ResponseEntity.ok(Collections.emptyList());
        }
        return ResponseEntity.ok(bookingService.getBookingsByCustomer(query.trim()));
    }
}