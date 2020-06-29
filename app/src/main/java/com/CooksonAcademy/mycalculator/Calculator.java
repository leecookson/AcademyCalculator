package com.CooksonAcademy.mycalculator;

import android.util.Log;


// currentValue will always be left side of an operation
// currentOperand will always be the right side
// currentOperator will hold last operator, pending receipt of a new operand (right side)
public class Calculator {

    long MAX_DIGITS = 12;
    long MAX_NUMBER = (long) (Math.pow(10, MAX_DIGITS - 1) + 1);

    public Calculator()
    {
        currentValue = Double.NaN;
        currentOperand = Double.NaN;
        currentOperator = Operator.CALC_NONE;
    }

    public void reset ()
    {
        currentValue = Double.NaN;
        currentOperand = Double.NaN;
        currentOperator = Operator.CALC_NONE;
    }

    public void setValue
            (double newValue)
    {
        currentValue = newValue;
    }

    public double getCurrentValue()
    {
        return currentValue;
    }

    public Operator getCurrentOperator() {
        return currentOperator;
    }

    public double getCurrentOperand() {
        return currentOperand;
    }

    public void setCurrentOperand(double currentOperand) {
        this.currentOperand = currentOperand;
    }

    /**
     * Simple line-oriented calculator program. The class
     * can also be used to create other calculator programs.
 */

    public enum  Operator {
        CALC_NONE, CALC_ADD, CALC_SUB, CALC_MUL, CALC_DIV, CALC_REM;
    };

    double currentValue = Double.NaN;
    Operator currentOperator = Operator.CALC_NONE;
    private double currentOperand = Double.NaN;
    double precision = 0.0001;

    /**
     * Returns n1 op n2, provided op is one of '+', '-', '*',or '/'.
     * Any other value of op throws UnknownOpException.
     */
    public void doOperation
    (Operator operator) throws DivideByZeroException, UnknownOpException
    {
        Log.v("dOP", "operator " + operator);
        Log.v("dOP", "currentValue " + currentValue);
        Log.v("dOP", "currentOperand " + currentOperand);
        Log.v("dOP", "currentOperator " + currentOperator);
        if (Double.isNaN(currentOperand) && Double.isNaN(currentValue)) {
            // if at beginning, do nothing, no value yet
            Log.v("dOp", "no currentValue, ignore op");

        } else if (currentOperator == Operator.CALC_NONE && Double.isNaN(currentOperand)) {
            // if user just did Equals, maybe entered digits
            Log.v("dOp", "none");
            currentOperator = operator;

        } else if (currentOperator == Operator.CALC_NONE && Double.isNaN(currentValue)) {
            // if user just entered only digits to begin
            Log.v("dOp", "none");
            currentValue = currentOperand;
            currentOperator = operator;
            setCurrentOperand(Double.NaN);  //saved operand as value, clear operand
        } else if (currentOperator != Operator.CALC_NONE && Double.isNaN(currentOperand)) {
            // ignore

        } else {
            // do operation based on existing operator and operand, set operand to new one
            Log.v("dOp", "ELSE");
            doCalculation();
            currentOperator = operator;
            setCurrentOperand(Double.NaN);

        }
        Log.v("dOp", "POST currentValue" + currentValue);
        Log.v("dOp", "POST currentOperand" + currentOperand);

//    } else {
//        Log.v("dOp", "calc");
//        doCalculation();
//        setCurrentOperand(0);
//    }
    }

    public void doDigit(double digit) {
        Log.v("dDig", "digit " + digit);
        Log.v("dDig", "currentValue " + currentValue);
        Log.v("dDig", "currentOperand " + currentOperand);
        Log.v("dDig", "currentOperator " + currentOperator);
        if (currentOperand > MAX_NUMBER) {
            currentOperand = Double.NaN;
            return;
        }

        if (currentOperator == Operator.CALC_NONE && Double.isNaN(currentOperand)) {
            currentOperand = digit;
            currentValue = Double.NaN;
        } else if (Double.isNaN(currentOperand)) {
            setCurrentOperand(digit);
        } else {
            setCurrentOperand(getCurrentOperand() * 10 + digit);
        }
        Log.v("dDig", "POST currentOperand " + currentOperand);
    }

    public void doEquals() {
        if (currentOperator == Operator.CALC_NONE && !Double.isNaN(currentOperand)) {
            // treat ## Equals as "current value is ##"
            currentValue = currentOperand;
            currentOperand = Double.NaN;
        }
        if (currentOperator == Operator.CALC_NONE) {
            // ignore equals when we don't have an operator yet
            return;
        }
        doCalculation();
        currentOperator = Operator.CALC_NONE;
        setCurrentOperand(Double.NaN);
    }

    void doCalculation() {
        Log.v("dCalc", "currentValue " + currentValue);
        Log.v("dCalc", "currentOperand " + currentOperand);
        Log.v("dCalc", "currentOperator " + currentOperator);
        switch (currentOperator) {
            case CALC_ADD:
                currentValue = currentValue + getCurrentOperand();
                break;
            case CALC_SUB:
                currentValue = currentValue - getCurrentOperand();
                break;
            case CALC_MUL:
                currentValue = currentValue * getCurrentOperand();
                break;
            case CALC_DIV:
                if ((-precision < getCurrentOperand()) && (getCurrentOperand() < precision)) {
                    Log.v("dCalc", "DIV_ZERO reset");
                    // reset, do not throw
                    reset();
                    break;
                }
                currentValue = currentValue / getCurrentOperand();
                break;
            default:
                throw new UnknownOpException("" + currentOperator);
        }
    }

    public void handleDivideByZeroException (DivideByZeroException e)
    {
        System.out.println("Dividing by zero.");
        System.out.println("Program aborted");
        System.exit(0);
    }

    public void handleUnknownOpException (UnknownOpException e)
    {
        System.out.println(e.getMessage());
        System.out.println("Try again from the beginning:");

        try {
            System.out.print("Format of each line: ");
            System.out.println("operator number");
            System.out.println("For example: + 3");
            System.out.println("To end, enter the letter e.");
            //doCalculation();
        } catch (UnknownOpException e2) {
            System.out.println(e2.getMessage());
            System.out.println("Try again at some other time.");
            System.out.println("Program ending.");
            System.exit(0);
        } catch (DivideByZeroException e3) {
            handleDivideByZeroException(e3);
        }
    }
}

