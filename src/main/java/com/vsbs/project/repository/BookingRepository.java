package com.vsbs.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.vsbs.project.entities.Booking;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByCustomerName(String customerName);
}