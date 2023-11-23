package com.laxmi.inventory.management.inventory.utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ServiceUtils {

    private static final Random random = new Random();
    private static final Set<Integer> generatedNumbers = new HashSet<>();

    public static synchronized int generateUniqueNumber() {
        if (generatedNumbers.size() == 90000) {
            throw new IllegalStateException("No more unique numbers available.");
        }

        int number;
        do {
            number = 10000 + random.nextInt(90000);
        } while (generatedNumbers.contains(number));

        generatedNumbers.add(number);
        return number;
    }

    public static double calculateDiscountedAmount(String discountPercentage, double totalAmount) {
        // Convert the discount percentage string to a double
        double discount = Double.parseDouble(discountPercentage.replace("%", ""));

        // Calculate the discount amount
        double discountAmount = (discount / 100) * totalAmount;

        // Subtract the discount amount from the total amount
        return totalAmount - discountAmount;
    }
}
