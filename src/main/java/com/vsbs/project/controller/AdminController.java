package com.vsbs.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vsbs.project.entities.Booking;
import com.vsbs.project.service.BookingService;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/all")
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<Booking> updateStatus(@PathVariable Long id, @RequestParam String status) {
        Booking updated = bookingService.updateStatus(id, status);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    // Also support POST for status update in case client proxies or browsers do not permit PUT
    @PostMapping("/updateStatus/{id}")
    public ResponseEntity<Booking> updateStatusPost(@PathVariable Long id, @RequestParam String status) {
        return updateStatus(id, status);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long id) {
        boolean deleted = bookingService.deleteBooking(id);
        if (deleted) {
            return ResponseEntity.ok("Booking with ID " + id + " was deleted successfully.");
        }
        return ResponseEntity.notFound().build();
    }

    // Also support POST for delete for maximum client compatibility
    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteBookingPost(@PathVariable Long id) {
        return deleteBooking(id);
    }
}