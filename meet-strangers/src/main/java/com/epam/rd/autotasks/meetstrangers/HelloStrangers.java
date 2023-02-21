package com.epam.rd.autotasks.meetstrangers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) throws IOException {
        //Write a program, asks for a number - amount of strangers to meet.
        //Then reads stranger names line by line and prints line by line "Hello, ...".
    	/*Asks for a number - amount of strangers to meet
		Then reads stranger names line by line
		And, finally, prints line by line "Hello, stranger name" for each stranger*/


    	/*If strangers count is zero, then program must print "Oh, it looks like there is no one here".
		If strangers count is negative, then program must print "Seriously? Why so negative?".*/
        Scanner scan = new Scanner(System.in);
        int amount = scan.nextInt();
        if (amount == 0) {
            System.out.println("Oh, it looks like there is no one here");
        }else if (amount<0) {
            System.out.println("Seriously? Why so negative?");
        }

        if (amount>0) {
            scan.nextLine();
            String[] names = new String[amount];
            for(int i = 0; i<amount; i++){
                names[i] = scan.nextLine();
            }
            for(int i = 0; i <names.length; i++) {
                System.out.println("Hello, " + names[i]);
            }
        }

    }
}