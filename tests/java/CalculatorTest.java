import app.Calc;
import app.Calculator;
import app.StackA;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    private Calc calc;

    @BeforeEach
    void setUp() {

        Calculator c = Calculator.getInstance();
        c.setStack(new StackA<>(10));
        calc = c;
    }

    @Test
    void verifySingleAddition() {
        assertEquals(5, calc.operate("23+"), "2 + 3 should equal 5");
    }

    @Test
    void verifyMultipleOperations() {
        assertEquals(25, calc.operate("23+5*"), "(2 + 3) * 5 should equal 25");
    }

    @Test
    void verifySubtractionAndAddition() {
        assertEquals(9, calc.operate("82-3+"), "(8 - 2) + 3 should equal 9");
    }

    @Test
    void verifyDivision() {
        assertEquals(2, calc.operate("84/"), "8 / 4 should equal 2");
    }

    @Test
    void verifyDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> calc.operate("80/"), "8 / 0 should throw ArithmeticException");
    }

    @Test
    void verifyComplexExpression() {
        assertEquals(35, calc.operate("52+83-*"), "(5 + 2) * (8 - 3) should equal 35");
    }

    @Test
    void verifyInsufficientOperandsThrowsException() {
        assertThrows(Exception.class, () -> calc.operate("5+"), "Insufficient operands should throw exception");
    }

    @Test
    void verifyInvalidTokenThrowsException() {
        assertThrows(Exception.class, () -> calc.operate("5a"), "Invalid token should throw exception");
    }
}
