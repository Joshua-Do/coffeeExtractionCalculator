/*
 * Coffee Extraction Calculator programmed by Joshua Do
 * Date last modified: 1/4/2021
 * Eventual plan is to create a GUI and have it be runnable as an app/executable
 */

import java.util.Scanner;

public class Main {
    public static float extractionCalc(float water, float coffee, float tds) {
        float extraction = 0;
        try {
            extraction = (water * tds) / coffee;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return extraction;
    }

    // Method c/o (https://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places)
    public static float round(float value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (float) tmp / factor;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float coffeeAmount = 0;
        float waterAmount = 0;
        float tds = 0;
        float extraction = 0;
        int decimalPlaces = 2;
        boolean continueYN = true;
        char userChoice = '!';

        while (continueYN != false) {
            System.out.println("A). Enter new coffee");
            System.out.println("B). Check Previous Coffees");
            System.out.println("C). Exit");
            try {
                userChoice = scanner.next().charAt(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
            switch (userChoice) {
                case 'a':
                case 'A':
                    System.out.println("Enter grams of coffee");
                    try {
                        coffeeAmount = scanner.nextFloat();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("Enter grams of water");
                    try {
                        waterAmount = scanner.nextFloat();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("Enter the TDS");
                    try {
                        tds = scanner.nextFloat();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    extraction = extractionCalc(waterAmount, coffeeAmount, tds);
                    extraction = round(extraction, decimalPlaces);

                    System.out.println("Your extraction percentage is %" + extraction);
                    break;
                case 'b':
                case 'B':
                    // code where user can check their logs of brewed coffee
                    break;
                case 'c':
                case 'C':
                    continueYN = false;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + userChoice);
            }
        }
    }
}