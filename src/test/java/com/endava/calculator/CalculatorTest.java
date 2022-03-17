package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.basic.BasicOperations;
import com.endava.calculator.expert.Expert;
import com.endava.calculator.expert.ExpertOperations;
import com.endava.extensions.TestReporterExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(TestReporterExtension.class)
public class CalculatorTest {

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
    public void shouldAddBigNum() {

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

    @ParameterizedTest
    @CsvSource({"1,2,3", "2,4,5"})
    @CsvFileSource(resources = "numberSource.csv")
    public void shouldAddMoreThan2Operands(int a, int b, int c) {

        //WHEN
        Integer result = basic.add(a, b, c);

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldAddNZeroOperands() {

        //WHEN
        Long result = basic.multiply(10);

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldAddNumbersGivenOperandZero() {

        //WHEN
        Long result = basic.multiply(5, 0);

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldAddNumbersGiven3Operands() {

        //WHEN
        Long result = basic.multiply(2, 3, 4);

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldAddNegativeNumbersGiven2Operands() {

        //WHEN
        Long result = basic.multiply(-5, 2);

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldAddPositiveNumbers() {

        //WHEN
        Double result = expert.pow(2, 3);

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldAddBase0Exponent0() {

        //WHEN
        Double result = expert.pow(0, 0);

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldAddExponent0() {

        //WHEN
        Double result = expert.pow(3, 0);

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldAddNegativeExponent() {

        //WHEN
        Double result = expert.pow(3, -2);

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldAddNumber0() {

        //WHEN
        Long result = expert.fact(0);

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldAddPositiveNumber() {

        //WHEN
        Long result = expert.fact(4);

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldAddBigNumber() {

        //WHEN
        Long result = expert.fact(26);

        //THEN
        System.out.println(result);// why is the result negative?
    }

    @Test
    public void shouldAddSoBigNumber() {

        //WHEN
        Long result = expert.fact(100);

        //THEN
        System.out.println(result);//what happened?
    }

}
