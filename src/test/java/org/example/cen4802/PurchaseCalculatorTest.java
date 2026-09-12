package org.example.cen4802;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PurchaseCalculatorTest {

    @Test
    void calculateSubtotal_withPriceAndQuantity_returnsCorrectSubtotal() {
        PurchaseCalculator calculator = new PurchaseCalculator();

        double result = calculator.calculateSubtotal(10.00, 3);

        assertEquals(30.00, result, 0.001);
    }

    @Test
    void calculateSalesTax_withSubtotal_returnsSixPointFivePercentTax() {
        PurchaseCalculator calculator = new PurchaseCalculator();

        double result = calculator.calculateSalesTax(100.00);

        assertEquals(6.50, result, 0.001);
    }

    @Test
    void calculateFinalTotal_withSubtotal_returnsSubtotalPlusTax() {
        PurchaseCalculator calculator = new PurchaseCalculator();

        double result = calculator.calculateFinalTotal(100.00);

        assertEquals(106.50, result, 0.001);
    }

    @Test
    void calculateSubtotal_withDecimalPrice_returnsCorrectSubtotal() {
        PurchaseCalculator calculator = new PurchaseCalculator();

        double result = calculator.calculateSubtotal(7.25, 4);

        assertEquals(29.00, result, 0.001);
    }
}