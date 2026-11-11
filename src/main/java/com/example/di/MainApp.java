package com.example.di;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService service = context.getBean(OrderService.class);
        service.placeOrder("Laptop");

        context.close();
    }
}
