package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.basic.BasicOperations;
import com.endava.calculator.expert.Expert;
import com.endava.calculator.expert.ExpertOperations;

public class TestCalculator {

    public static void main(String[] args) {

        BasicOperations b = new Basic(5);
        System.out.println("Add: " + b.add(2, 3, 4, 5));
        System.out.println("Substract: " + b.substract(2));
        System.out.println("Multiply: " + b.multiply(3,2));
        System.out.println("Divide: " + b.divide(10,3));
        System.out.println('\n');

        ExpertOperations e = new Expert(4);
        System.out.println("Pow: " + e.pow(2,-5));
        System.out.println("Root: " + e.root(10));
        System.out.println("Fact: " + e.fact(3));

        System.out.println(e.calculate("22.2 + 33.3 + 5 + 6"));
        System.out.println(e.calculate("-3 -5 * 3"));
        System.out.println(e.calculate("2 + (-3-5) * (-7-5)"));
        System.out.println(e.calculate("(3 + 2) / 5 * 5 - (8 / 2)"));

        System.out.println(e.calculate("2 ^ 3"));
    }
}
