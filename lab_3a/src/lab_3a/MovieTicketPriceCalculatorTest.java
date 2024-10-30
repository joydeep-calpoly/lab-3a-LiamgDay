package lab_3a;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

class MovieTicketPriceCalculatorTest {
	
	MovieTicketPriceCalculator calc = new MovieTicketPriceCalculator(
            LocalTime.of(12, 0),
            LocalTime.of(16, 0), 
            12, 65);
    
    @Test
    void testComputeDiscountSenior() {
        int discount = calc.computeDiscount(66);
        assertEquals(400, discount);
    }
    
    @Test
    void testComputeDiscountChild() {
        int discount = calc.computeDiscount(-1); 
        assertEquals(300, discount);
    }
    
    @Test
    void testComputePriceStandard() {
        int price = calc.computePrice(LocalTime.of(18, 0), 20);
        assertEquals(2700, price);
    }
    
    @Test
    void testComputePriceMatinee() {
        int price = calc.computePrice(LocalTime.of(13, 0), 20); 
        assertEquals(2400, price);
    }
    
    @Test
    void testComputePriceMatineeAndChild() {
        int price = calc.computePrice(LocalTime.of(12, 0), 5);
        assertEquals(2100, price);
    }
}