package com.jjgr.store_demo.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(
        name = "product_sequence",
        sequenceName = "product_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "product_sequence"
    )

    private Long id;
    private String name;
    private int stock;
    private double price;

    public Product(){}

    //Cinstructors
    public Product(Long id, String name, int stock, double price){
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public Product(String name, int stock, double price){    
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    //Getters
    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getStock(){
        return stock;
    }

    public double getPrice(){
        return price;
    }

    //Setters
    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setStock(int stock){
        this.stock = stock; 
    }

    public void setPrice(double price){
        this.price = price;
    }
}
