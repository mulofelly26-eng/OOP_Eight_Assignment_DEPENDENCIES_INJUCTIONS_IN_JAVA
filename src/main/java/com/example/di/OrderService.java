package com.example.di;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class OrderService {
    private final OrderRepository repository;
    private final Notifier notifier;

    // Spring injects both dependencies automatically.
    // (@Autowired is optional when a class has a single constructor.)
    @Autowired
    public OrderService(OrderRepository repository, Notifier notifier) {
        this.repository = repository;
        this.notifier = notifier;
    }

    public void placeOrder(String order) {
        repository.save(order);
        notifier.send("Your order '" + order + "' has been placed.");
    }
}
