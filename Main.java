package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner creditcard = new Scanner(System.in);
        System.out.print("Input your credit card number: ");
        String ccnum;
        ccnum = creditcard.nextLine();
        System.out.println(validateccnum(ccnum));
    }

    private static String validateccnum(String ccnum) {
        int[] ccint = new int[ccnum.length()];
        for (int i = 0; i < ccnum.length(); i++) {
            ccint[i] = Integer.parseInt(ccnum.substring(i, i + 1));
        }
        for (int i = ccint.length - 2; i >= 0; i = i - 2) {
            int tv = ccint[i];
            tv = tv * 2;
            if (tv > 9) {
                tv = tv % 10 + 1;
            }
            ccint[i] = tv;
        }
        int sum = 0;
        for (int i = 0; i < ccint.length; i++) {
            sum += ccint[i];
        }
        if (sum % 10 == 0 && ccnum.startsWith("3")) {
            System.out.println("AMEX");
        } else if (sum % 10 == 0 && ccnum.startsWith("4")) {
            System.out.println("VISA");
        } else if (sum % 10 == 0 && ccnum.startsWith("5")) {
            System.out.println("MASTERCARD");}
        else {
            System.out.println("INVALID");
        }
        System.out.print("Number:");
        return ccnum;
    }
}
