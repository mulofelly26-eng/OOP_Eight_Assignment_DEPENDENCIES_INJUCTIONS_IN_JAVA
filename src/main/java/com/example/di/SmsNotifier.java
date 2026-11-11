package com.example.di;
import org.springframework.stereotype.Component;

@Component("smsNotifier")
public class SmsNotifier implements Notifier{
    @Override
    public void send(String message) {
        System.out.println("SMS sent: " + message);
    }

}
