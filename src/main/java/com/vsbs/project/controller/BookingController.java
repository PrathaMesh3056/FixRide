package com.vsbs.project.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.vsbs.project.entities.Booking;
import com.vsbs.project.service.BookingService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    
    @GetMapping("/mybookings/{customerName}")
    public Booking getBookingByCustomerName(@PathVariable String customerName) {
        List<Booking> bookings = bookingService.getBookingsByCustomer(customerName);
        if (bookings != null && !bookings.isEmpty()) {
            return bookings.get(0); // return first booking
        } else {
            return null;
        }
    }

    @PostMapping("/book")
    public Booking bookService(@ModelAttribute Booking booking) {
        return bookingService.bookService(booking);
    }

   
}