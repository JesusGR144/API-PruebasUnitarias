package com.jjgr.store_demo.cart;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import com.jjgr.store_demo.user.User;

@Entity
@Table
public class Cart {
    @Id
    @SequenceGenerator(name = "cart_sequence", sequenceName = "cart_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_sequence")

    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Cart() {
    }

    public Cart(User user) {
        this.user = user;
    }

    public Long getId(){
        return id;
    }

    public User getUser(){
        return user;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setUser(User user){
        this.user = user;
    }
}
