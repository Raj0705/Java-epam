package com.epam.rd.autotasks.arithmeticexpressions;

public class Variable implements Expression {
    private String name;
    private int value;

    public Variable(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // returns the value of the variable.
    @Override
    public int evaluate() {
        return value;
    }

    //returns the name of the variable.
    @Override
    public String toExpressionString() {
        return name;
    }
}