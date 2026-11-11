package com.example.di;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
    public void save(String order) {
        System.out.println("Order saved to database: " + order);
    }
}
