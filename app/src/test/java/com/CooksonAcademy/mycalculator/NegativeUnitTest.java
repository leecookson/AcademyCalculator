package com.CooksonAcademy.mycalculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class NegativeUnitTest {
    @Test
    public void ignoreOperatorFirst_isCorrect() {
        Calculator calc = new Calculator();
        calc.doOperation(Calculator.Operator.CALC_DIV);
        calc.doDigit(1);
        calc.doOperation(Calculator.Operator.CALC_ADD);
        calc.doDigit(1);
        calc.doEquals();

        assertEquals(2, calc.getCurrentValue(), 0);
    }

    @Test
    public void ignoreMultipleOperator_isCorrect() {
        Calculator calc = new Calculator();
        calc.doDigit(1);
        calc.doOperation(Calculator.Operator.CALC_ADD);
        calc.doOperation(Calculator.Operator.CALC_ADD);
        calc.doDigit(1);
        calc.doEquals();

        assertEquals(2, calc.getCurrentValue(), 0);
    }

    @Test
    public void resetWhenDividyByZero_isCorrect() {
        Calculator calc = new Calculator();
        calc.doDigit(1);
        calc.doOperation(Calculator.Operator.CALC_DIV);
        calc.doDigit(0);
        calc.doEquals();

        assertEquals(Double.NaN, calc.getCurrentValue(),0);
        assertEquals(Calculator.Operator.CALC_NONE, calc.getCurrentOperator());
        assertEquals(Double.NaN, calc.getCurrentOperand(), 0);
    }

    @Test
    public void digitAfterEqualsResets_isCorrect() {
        Calculator calc = new Calculator();
        calc.doDigit(4);
        calc.doOperation(Calculator.Operator.CALC_ADD);
        calc.doDigit(4);
        calc.doEquals();
        assertEquals(8, calc.getCurrentValue(), 0);

        calc.doDigit(2);
        assertEquals(Double.NaN, calc.getCurrentValue(),0);
        assertEquals(Calculator.Operator.CALC_NONE, calc.getCurrentOperator());
        assertEquals(2, calc.getCurrentOperand(), 0);
    }

    @Test
    public void ignoreMultipleOperatorsAfterEquals_isCorrect() {
        Calculator calc = new Calculator();
        calc.doDigit(7);
        calc.doOperation(Calculator.Operator.CALC_ADD);
        calc.doOperation(Calculator.Operator.CALC_ADD);
        calc.doEquals();
        assertEquals(Double.NaN, calc.getCurrentValue(), 0);

        calc.doOperation(Calculator.Operator.CALC_ADD);
        calc.doOperation(Calculator.Operator.CALC_ADD);
        calc.doEquals();

        assertEquals(Double.NaN, calc.getCurrentValue(), 0);
    }

    @Test
    public void maxDigitsGood_isCorrect() {
        double testValue = Double.parseDouble("777777777777");
        Calculator calc = new Calculator();
        calc.doDigit(7);
        calc.doDigit(7);
        calc.doDigit(7);

        calc.doDigit(7);
        calc.doDigit(7);
        calc.doDigit(7);

        calc.doDigit(7);
        calc.doDigit(7);
        calc.doDigit(7);

        calc.doDigit(7);
        calc.doDigit(7);
        calc.doDigit(7);

        assertEquals(testValue, calc.getCurrentOperand(), 0);
    }

    @Test
    public void maxDigitsBad_isCorrect() {
        double testValue = Double.parseDouble("777777777777");
        Calculator calc = new Calculator();
        calc.doDigit(7);
        calc.doDigit(7);
        calc.doDigit(7);

        calc.doDigit(7);
        calc.doDigit(7);
        calc.doDigit(7);

        calc.doDigit(7);
        calc.doDigit(7);
        calc.doDigit(7);

        calc.doDigit(7);
        calc.doDigit(7);
        calc.doDigit(7);

        calc.doDigit(7);

        assertEquals(Double.NaN, calc.getCurrentOperand(), 0);
    }

}