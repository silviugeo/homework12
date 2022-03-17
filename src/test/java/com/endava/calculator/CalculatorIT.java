package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.basic.BasicOperations;
import com.endava.calculator.expert.Expert;
import com.endava.calculator.expert.ExpertOperations;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class CalculatorIT {

    private BasicOperations basic;
    private ExpertOperations expert;

    @BeforeAll
    public static void setUpAllTests(){
        System.out.println("Before All");
    }

    @AfterAll
    public static void tearDownAllTests(){
        System.out.println("After All");
    }

    @BeforeEach
    public void setUpEachTest() {
        basic = new Basic();
        expert = new Expert();
        System.out.println("Before Each");
    }

    @AfterEach
    public void tearDownEachTest(){
        System.out.println("After Each");
    }

    @Tags( {@Tag("smoke"), @Tag("ui")} )
    @ParameterizedTest
    @MethodSource("numberProvider")
    public void shouldAddNumbersGivenOperand0(int a, int b) {

        //WHEN
        Integer result = basic.add(a, b);

        //THEN
        System.out.println(result);
    }

    public static List<Arguments> numberProvider(){
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(0, 2));
        argumentsList.add(Arguments.of(2, 0));

        return argumentsList;
    }

    @Tag("smoke")
    @Test
    public void shouldNegativeNumbers() {

        //WHEN
        Integer result = basic.add(-2,-4);

        //THEN
        System.out.println(result);
    }

    @Tags( {@Tag("smoke"), @Tag("api")} )
    @Test
    public void shouldAddBigNumber() {

        //WHEN
        Integer result = basic.add(Integer.MIN_VALUE, 1);

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldAddNoOperands() {

        //WHEN
        Integer result = basic.add();

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldAdd1Operands() {

        //WHEN
        Integer result = basic.add(167);

        //THEN
        System.out.println(result);
    }

}
