package com.rpam.rd.autotasks;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CatchEmAll {

    static Exception exception = new FileNotFoundException();

    public static void riskyMethod() throws Exception {
        throw exception;
    }

    public static void main(String[] args) throws Exception {
        try {
            riskyMethod();
        }catch (FileNotFoundException exp) {
            Exception exception2 = new  IllegalArgumentException("Resource is missing");
            exception2.initCause(exp);
            throw exception2;

        }catch(ArithmeticException | NumberFormatException exp) {
            System.err.append(exp.getMessage());
            System.out.println(exp.getMessage());
        }catch(IOException exp) {
            Exception exception3 = new  IllegalArgumentException("Resource error");
            exception3.initCause(exp);
            throw exception3;

        }


    }
}