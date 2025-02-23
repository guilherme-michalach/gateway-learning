package com.library.custom_logger.utils;

import java.util.Random;

public class TraceIdGenerator {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWYXZ";

    public static String generateTraceId() {
        var builder = new StringBuilder();
        var random = new Random();

        for (int i = 0; i < 3; i++) {
            builder.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }

        for (int i = 0; i < 16; i++) {
            builder.append(random.nextInt());
        }

        return builder.toString();
    }

}
