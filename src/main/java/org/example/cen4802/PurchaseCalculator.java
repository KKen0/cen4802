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
}