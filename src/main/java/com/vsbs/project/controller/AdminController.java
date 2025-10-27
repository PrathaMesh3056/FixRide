package com.vsbs.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.vsbs.project.entities.Booking;
import com.vsbs.project.service.BookingService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private BookingService bookingService;

    // Admin dashboard view (after login)
    @GetMapping("/dashboard")
    public String showAdminDashboard(Model model) {
        model.addAttribute("bookings", bookingService.getAllBookings());
        return "admin-dashboard";  // Must exist in templates/
    }

    // Show admin login page
    @GetMapping("/login")
    public String showAdminLoginPage() {
        return "admin-login";
    }

    // Get all bookings (JSON)
    @ResponseBody
    @GetMapping("/all")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    // Update booking status (JSON)
    @ResponseBody
    @PostMapping("/updateStatus/{id}")
    public Booking updateStatus(@PathVariable Long id, @RequestParam String status) {
        return bookingService.updateStatus(id, status);
    }

    // Delete booking and redirect to dashboard
    @PostMapping("/delete/{id}")
    public String deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return "redirect:/admin/dashboard";
    }
}
