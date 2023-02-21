package com.epam.rd.autotasks;

class Spiral {
    static int[][] spiral(int rows, int columns) {
        int count = 0;
        int number = 1;
        int endValue = rows*columns;

        int array[][] = new int[rows][columns];

        while(number <= endValue) {
            for(int r = count; r<columns; r++) {
                array[count][r] = number;
                number++;
            }
            for(int h = count+1; h<rows; h++) {
                array[h][columns-1] = number;
                number++;
            }
            if (number <= endValue) {
                for(int r = columns-2; r>=count; r--) {
                    array[rows-1][r] = number;
                    number++;
                }
            }
            for(int h = rows-2; h>count; h-- ) {
                array[h][count] = number;
                number++;
            }
            count++;
            columns--;
            rows--;

        }


        return array;
    }
}