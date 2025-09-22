package com.klef.fsd.springboot.model;



import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "bookart_table")
public class BookArt 
{
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "art_id")
    private Art art;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(nullable = false)
    private int bookedQuantity;  // how many pieces booked (for prints, replicas)

    @Column(nullable = false)
    private String status;  // e.g., Pending, Confirmed, Cancelled

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime bookingTime; // Auto set at record creation

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Art getArt() {
        return art;
    }
    public void setArt(Art art) {
        this.art = art;
    }

    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getBookedQuantity() {
        return bookedQuantity;
    }
    public void setBookedQuantity(int bookedQuantity) {
        this.bookedQuantity = bookedQuantity;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }
    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    @Override
    public String toString() {
        return "BookArt [id=" + id + ", art=" + art + ", customer=" + customer 
               + ", bookedQuantity=" + bookedQuantity + ", status=" + status 
               + ", bookingTime=" + bookingTime + "]";
    }
}
