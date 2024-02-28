package org.example.logging;

public class DatabaseLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("Database logging completed " +message);
    }
}
