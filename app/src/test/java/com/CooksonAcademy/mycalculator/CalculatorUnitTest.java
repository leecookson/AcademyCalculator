package com.CooksonAcademy.mycalculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import com.CooksonAcademy.mycalculator.Calculator;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CalculatorUnitTest {
    @Test
    public void addition_isCorrect() {
        Calculator calc = new Calculator();
        calc.doDigit(2);
        calc.doOperation(Calculator.Operator.CALC_ADD);
        calc.doDigit(2);
        calc.doEquals();
        assertEquals(4, calc.getCurrentValue(), 0);
    }

    @Test
    public void subtraction_isCorrect() {
        Calculator calc = new Calculator();
        calc.doDigit(2);
        calc.doOperation(Calculator.Operator.CALC_SUB);
        calc.doDigit(1);
        calc.doEquals();
        assertEquals(1, calc.getCurrentValue(), 0);

    }

    @Test
    public void division_isCorrect() {
        Calculator calc = new Calculator();
        calc.doDigit(1);
        calc.doDigit(0);
        calc.doOperation(Calculator.Operator.CALC_DIV);
        calc.doDigit(5);
        calc.doEquals();
        assertEquals(2, calc.getCurrentValue(), 0);

    }

    @Test
    public void multiplication_isCorrect() {
        Calculator calc = new Calculator();
        calc.doDigit(1);
        calc.doDigit(0);
        calc.doOperation(Calculator.Operator.CALC_MUL);
        calc.doDigit(5);
        calc.doEquals();
        assertEquals(50, calc.getCurrentValue(), 0);
    }

    @Test
    public void simpleChaining_isCorrect() {
        Calculator calc = new Calculator();

        calc.reset(); // Clear
        calc.doDigit(1);
        calc.doOperation(Calculator.Operator.CALC_ADD);
        calc.doDigit(2);
        calc.doOperation(Calculator.Operator.CALC_ADD);
        calc.doDigit(3);
        calc.doOperation(Calculator.Operator.CALC_ADD);
        calc.doDigit(4);
        calc.doOperation(Calculator.Operator.CALC_ADD);
        calc.doDigit(5);
        calc.doEquals();
        assertEquals(15, calc.getCurrentValue(), 0);
    }

    @Test
    public void equalChaining_isCorrect() {
        Calculator calc = new Calculator();

        calc.reset(); // Clear
        calc.doDigit(2);
        calc.doOperation(Calculator.Operator.CALC_ADD);
        calc.doDigit(2);
        calc.doEquals();
        calc.doOperation(Calculator.Operator.CALC_SUB);
        calc.doDigit(1);
        calc.doEquals();
        assertEquals(3, calc.getCurrentValue(), 0);
    }

    @Test
    public void reset_isCorrect() {
        Calculator calc = new Calculator();
        calc.doDigit(1);
        calc.doOperation(Calculator.Operator.CALC_ADD);
        calc.doDigit(2);
        calc.reset();
        assertEquals(Double.NaN, calc.getCurrentValue(), 0);
        assertEquals(Calculator.Operator.CALC_NONE, calc.getCurrentOperator());

    }

    @Test
    public void simpleNumberEqual_isCorrect() {
        Calculator calc = new Calculator();
        calc.doDigit(1);
        calc.doEquals();
        assertEquals(1, calc.getCurrentValue(), 0);
        assertEquals(Calculator.Operator.CALC_NONE, calc.getCurrentOperator());
    }

    @Test
    public void numberEqualAfterEqual_isCorrect() {
        Calculator calc = new Calculator();
        calc.doDigit(1);
        calc.doOperation(Calculator.Operator.CALC_ADD);
        calc.doDigit(3);
        calc.doEquals();

        calc.doDigit(1);
        calc.doEquals();
        assertEquals(1, calc.getCurrentValue(), 0);
        assertEquals(Calculator.Operator.CALC_NONE, calc.getCurrentOperator());
    }
}