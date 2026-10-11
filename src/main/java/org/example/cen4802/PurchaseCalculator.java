package org.example.cen4802;

public class PurchaseCalculator {

    private static final double TAX_RATE = 0.065;

    public double calculateSubtotal(double price, int quantity) {
        return price * quantity;
    }

    public double calculateSalesTax(double subtotal) {
        return subtotal * TAX_RATE;
    }

    public double calculateFinalTotal(double subtotal) {
        return subtotal + calculateSalesTax(subtotal);
    }

    public double calculateDiscount(double subtotal, double discountPercent) {
        return subtotal * (discountPercent / 100.0);
    }

    public double calculateFinalTotal(double subtotal, double discountPercent) {
        double discount = calculateDiscount(subtotal, discountPercent);
        double discountedSubtotal = subtotal - discount;

        return discountedSubtotal + calculateSalesTax(discountedSubtotal);
    }
}