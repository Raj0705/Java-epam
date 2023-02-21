package com.epam.rd.autotasks.snail;

import java.util.Scanner;

public class Snail {
    public static void main(String[] args) {
        //Write a program that reads a,b and h (line by lyne in this order) and prints
        //the number of days for which the snail reach the top of the tree.
        //a - feet that snail travels up each day, b - feet that slides down each night, h - height of the tree
        Scanner sc = new Scanner(System.in);
        int c, d, h;
        c = sc.nextInt();
        d = sc.nextInt();
        h = sc.nextInt();
        if (c <= d) {
            if (d > h) {
                System.out.println(1);
            } else {
                System.out.println("Impossible");
            }
        } else {
            int dt = 0, days = 0;
            while (dt < h) {
                dt += c;
                if (dt >= h) {
                    System.out.println(days + 1);
                    break;
                }
                dt -= d;
                days++;
            }
        }
        sc.close();

    }
    }
