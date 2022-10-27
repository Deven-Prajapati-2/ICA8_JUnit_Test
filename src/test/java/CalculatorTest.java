import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @org.junit.jupiter.api.Test
    void add() {
        assertEquals(4, Calculator.add(2, 2));
    }

    @org.junit.jupiter.api.Test
    void multiply() {
        assertEquals(4, Calculator.multiply(2, 2));
    }
}