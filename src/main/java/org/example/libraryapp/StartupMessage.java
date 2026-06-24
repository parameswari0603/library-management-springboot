package org.example.libraryapp;

import org.springframework.stereotype.Component;

@Component
public class StartupMessage {

    public StartupMessage() {
        System.out.println("Library App Started");
    }
}