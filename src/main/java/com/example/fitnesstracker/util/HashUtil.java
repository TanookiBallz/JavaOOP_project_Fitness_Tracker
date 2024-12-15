package com.example.fitnesstracker.util;

import java.security.MessageDigest;

public class HashUtil {
    public static String hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digested = md.digest(input.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : digested) sb.append(String.format("%02x", b));
            return sb.toString();
        } catch(Exception e) {
            return null;
        }
    }
}