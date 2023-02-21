package com.epam.rd.autotasks.arithmeticexpressions;

public class Expressions {

    public static Variable var(String name, int value) {
        Variable variable = new Variable(name, value);
        return variable;
    }

    public static Expression val(int value) {
        Expression expr = new Expression() {

            @Override
            public int evaluate() {
                return value;
            }

            @Override
            public String toExpressionString() {
                if (value < 0) {
                    return "(" + value + ")";
                }
                return value + "";
            }
        };
        return expr;
    }

    public static Expression sum(Expression... members) {
        Expression expr = new Expression() {

            @Override
            public int evaluate() {
                int s = 0;
                for (Expression member : members) {
                    s = s + member.evaluate();
                }
                return s;
            }

            @Override
            public String toExpressionString() {

                String s = members[0].toExpressionString();
                for (int i = 1; i < members.length; i++) {
                    s = s + " + " + members[i].toExpressionString();
                }
                s = "(" + s + ")";
                return s;
            }
        };
        return expr;
    }

    public static Expression product(Expression... members) {
        Expression expr = new Expression() {

            @Override
            public int evaluate() {
                int s = 1;
                for (Expression member : members) {
                    s = s * member.evaluate();
                }
                return s;
            }

            @Override
            public String toExpressionString() {

                String s = members[0].toExpressionString();
                for (int i = 1; i < members.length; i++) {
                    s = s + " * " + members[i].toExpressionString();
                }
                s = "(" + s + ")";
                return s;
            }
        };
        return expr;
    }

    public static Expression difference(Expression minuend, Expression subtrahend) {
        Expression expr = new Expression() {
            @Override
            public int evaluate() {
                return minuend.evaluate() - subtrahend.evaluate();
            }

            @Override
            public String toExpressionString() {
                return "(" + minuend.toExpressionString()  + " - " + subtrahend.toExpressionString() + ")";
            }};
        return expr;
    }

    public static Expression fraction(Expression dividend, Expression divisor) {

        Expression expr = new Expression() {
            @Override
            public int evaluate() {
                return dividend.evaluate() / divisor.evaluate();
            }

            @Override
            public String toExpressionString() {
                return "(" + dividend.toExpressionString()  + " / " + divisor.toExpressionString() + ")";
            }};
        return expr;
    }

}