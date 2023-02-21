package com.epam.rd.autotasks.max;

import java.util.Arrays;
import java.util.OptionalInt;

public class MaxMethod {
    public static OptionalInt max(int[] values) {
        OptionalInt optional;
        if(values == null || values.length == 0) {
            optional = OptionalInt.empty();
        }else{
            Arrays.sort(values);
            optional = OptionalInt.of(values[values.length-1]);
        }
        return optional;
    }
}