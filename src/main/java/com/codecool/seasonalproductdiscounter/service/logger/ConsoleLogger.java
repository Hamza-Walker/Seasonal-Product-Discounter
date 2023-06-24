package com.codecool.seasonalproductdiscounter.service.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsoleLogger implements Logger{
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void logInfo(String message) {
    String logEntry = formatLogEntry("INFO", message);
        System.out.println(logEntry);
    }

    @Override
    public void logError(String message) {
        String logEntry = formatLogEntry( "ERROR", message);
        System.out.println(logEntry);

    }

    private String formatLogEntry(String type, String message){
        String timestamp = LocalDateTime.now().format(formatter);
        return String.format("[%s] [%s] %s", timestamp, type, message);    }
}
