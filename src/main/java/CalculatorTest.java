import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorTest {
    Model model;
    Polynomial p1;
    Polynomial p2;

    @BeforeEach
    public void setUp() {
        model = new Model();
        p1 = new Polynomial("x^3-x^2+4*x-1");
        p2 = new Polynomial("3*x^2+2*x+x");
    }

    @Test
    public void testAdd() {
        model.add(p1, p2);
        assertTrue(model.getResult().equals("x^3+2*x^2+7*x-1"), "The result of adding x^3-x^2+4*x-1 and 3*x^2+2*x+x is x^3+2*x^2+7*x-1");
    }

    @Test
    public void testSubstract() {
        model.sub(p1, p2);
        assertTrue(model.getResult().equals("x^3-4*x^2+x-1"), "The result of substraction 3*x^2+2*x+x from x^3-x^2+4*x-1 is x^3-4*x^2+x-1");
    }

    @Test
    public void testDerivate() {
        model.derivate(p1);
        assertTrue(model.getResult().equals("3*x^2-2*x+4"), "The derivative of x^3-x^2+4*x-1 is 3*x^2-2*x+4");
    }

    @Test
    public void testIntegrate() {
        model.integrate(p1);
        assertTrue(model.getResult().equals("0,25*x^4-0,33*x^3+2*x^2-x"), "The result of integrating x^3-x^2+4*x-1 is 0.25*x^4-0.33*x^3+2*x^2-x");
    }

    @Test
    public void testMultiply() {
        model.multiply(p1, p2);
        assertTrue(model.getResult().equals("3*x^5+9*x^3+9*x^2-3*x"), "The result of multiplying x^3-x^2+4*x-1 and 3*x^2+2*x+x is 3*x^5+9*x^3+9*x^2-3*x");
    }
}
