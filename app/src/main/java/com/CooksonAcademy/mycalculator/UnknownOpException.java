package com.CooksonAcademy.mycalculator;

public class UnknownOpException
        extends ArithmeticException
{

    String message;

    public UnknownOpException(String message)
    {
        this.message = "Unknown Operator " + message;
    }

    public String toString()
    {
        return( message );
    }
}