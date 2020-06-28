package com.CooksonAcademy.mycalculator;

public class DivideByZeroException
        extends ArithmeticException
{

    String message;

    public DivideByZeroException()
    {
        this.message = "Divide By Zero";
    }

    public String toString()
    {
        return( message );
    }
}