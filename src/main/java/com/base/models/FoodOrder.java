package com.base.models;

import jakarta.persistence.*;

@Entity
public class FoodOrder {

    @Id
    @GeneratedValue
    private long id;

    private String status;
    private double totalamount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // ✅ getters & setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(double totalamount) {
        this.totalamount = totalamount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}