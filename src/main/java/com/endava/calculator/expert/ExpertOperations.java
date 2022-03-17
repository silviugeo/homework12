package com.endava.calculator.expert;

import com.endava.calculator.basic.BasicOperations;

public interface ExpertOperations extends BasicOperations {

    abstract double pow(double base, double exponent);
    abstract double root(int a);
    abstract long fact(int n);
    abstract long factRec(int n);
    abstract double calculate(String s);
}
