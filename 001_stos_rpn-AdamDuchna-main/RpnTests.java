import static org.junit.jupiter.api.Assertions.*;

public class RpnTests {
    @org.junit.jupiter.api.Test
    void testRPNAddition(){
        assertEquals("5", Rpn.calcExpression("2 3 +"));
    }

    @org.junit.jupiter.api.Test
    void testRPNSubtraction(){
        assertEquals("1", Rpn.calcExpression("3 2 -"));
    }

    @org.junit.jupiter.api.Test
    void testRPNMultiplication(){
        assertEquals("6", Rpn.calcExpression("3 2 *"));
    }

    @org.junit.jupiter.api.Test
    void testInvalidRPN(){
        assertEquals("Invalid RPN form", Rpn.calcExpression("5 3 * -"));
    }

    @org.junit.jupiter.api.Test
    void testInvalidRPNOperator(){
        assertEquals("Invalid operator", Rpn.calcExpression("5 3 /"));
    }

    @org.junit.jupiter.api.Test
    void testRPNRandomData(){
        assertEquals("Invalid RPN form", Rpn.calcExpression("51982f fff al 0 !"));
    }

    @org.junit.jupiter.api.Test
    void testInvalidRPNTooManyOperands(){
        assertEquals("Invalid RPN form", Rpn.calcExpression("5 3 4 * 4 - 15 "));
    }

    @org.junit.jupiter.api.Test
    void testIRPNValidData(){
        assertEquals("13", Rpn.calcExpression("5 3 4 * 4 - +"));
    }

    @org.junit.jupiter.api.Test
    void testIRPNValidDataNegativeValues(){
        assertEquals("-11", Rpn.calcExpression("5 -3 4 * 4 - +"));
    }
}
