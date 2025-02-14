package com.muted987.simulation;

import java.util.Scanner;

public class Input {

    private static final Scanner scanner = new Scanner(System.in);


    public static int integer(boolean isForMenu) {
        while (true) {
            int result;
            String input = scanner.nextLine();
            if (validate(input)) {
                result = Character.getNumericValue(input.charAt(0));
            } else {
                System.out.println("Invalid input. Try again");
                continue;
            }
            if (isForMenu) {
               if (validateForMenu(result)) {
                   return result;
               } else {
                   System.out.println("Invalid input. Try again");
               }
            } else {
                return result;
            }
        }
    }

    private static boolean validate(String result) {
        return result.length() == 1 && Character.isDigit(result.charAt(0));
    }

    private static boolean validateForMenu(int integer) {
        return !(integer < 0 || integer > 3);
    }
}
