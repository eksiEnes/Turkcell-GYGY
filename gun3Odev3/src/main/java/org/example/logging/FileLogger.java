package org.example.logging;

public class FileLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("File logging completed " + message);
    }
}
