/*
* Coffee Extraction Calculator programmed by Joshua Do
* Date last modified: 1/4/2021
* Eventual plan is to create a GUI and have it be runnable as an app/executable
 */

import java.util.Scanner;

public class Main {
    public static double extractionCalc(double water, double coffee, double tds) {
        double extraction = 0;
        try {
            extraction = (water * tds) / coffee;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return extraction;
    }
    // Method c/o (https://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places)
    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double coffeeAmount = 0;
        double waterAmount = 0;
        double tds = 0;
        double extraction = 0;
        int decimalPlaces = 2;

        System.out.println("Enter grams of coffee");
        try {
            coffeeAmount = scanner.nextDouble();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Enter grams of water");
        try {
            waterAmount = scanner.nextDouble();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Enter the TDS");
        try {
            tds = scanner.nextDouble();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        extraction = extractionCalc(waterAmount, coffeeAmount, tds);
        extraction = round(extraction, decimalPlaces);

        System.out.println("Your extraction percentage is %" +extraction);
    }
}