import app.Calc;
import app.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    private Calc calc;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    @Test
    void verifySingleAddition() {
        var result = calc.operate("23+");
        assertEquals(5, result, "2 + 3 should equal 5");
    }

    @Test
    void verifyMultipleOperations() {
        var result = calc.operate("23+5*"); // (2 + 3) * 5
        assertEquals(25, result, "(2 + 3) * 5 should equal 25");
    }

    @Test
    void verifySubtractionAndAddition() {
        var result = calc.operate("82-3+"); // (8 - 2) + 3
        assertEquals(9, result, "(8 - 2) + 3 should equal 9");
    }

    @Test
    void verifyDivision() {
        var result = calc.operate("84/"); // 8 / 4
        assertEquals(2, result, "8 / 4 should equal 2");
    }

    @Test
    void verifyDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> calc.operate("80/"), "8 / 0 should be math error");
    }

    @Test
    void verifyComplexExpression() {
        var result = calc.operate("52+83-*"); // (5 + 2) * (8 - 3)
        assertEquals(35, result, "Expression should evaluate correctly");
    }

    @Test
    void verifyInsufficientOperandsThrowsException() {
        assertThrows(Exception.class, () -> calc.operate("5+"), "Insufficient number of operands");
    }

    @Test
    void verifyOperandIsNotValidThrowsException() {
        assertThrows(Exception.class, () -> calc.operate("5a"));
    }

}
