package com.muted987.simulation.render;

import com.muted987.simulation.entity.EntitySymbol;
import com.muted987.simulation.validator.Validator;

import java.util.Scanner;

public class Input {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String INVALID_INPUT_CAPTION = "Invalid input. Try again";


    public static int optionForMenu(boolean isForMenu) {
        while (true) {
            try {
                String input = scanner.nextLine();
                int result;

                if (isForMenu && Validator.validateInputForMainMenu(input)) {
                    result = getIntFromInput(input);
                    if (Validator.validateIntForMainMenu(result)) {
                        return result;
                    }
                }
            } catch (Exception e) {
                System.out.println(INVALID_INPUT_CAPTION);
            }
        }
    }

    public static int integer() {
        while (true) {
            String input = scanner.next();
            if (Validator.isInteger(input)) {
                return Integer.parseInt(input);
            } else {
                System.out.println(INVALID_INPUT_CAPTION);
            }
        }

    }
    private static int getIntFromInput(String input) {
        return Integer.parseInt(input);
    }

    private static EntitySymbol getEntitySymbolFromInput(String input) {
        EntitySymbol[] entitySymbolArray = EntitySymbol.values();
        for (EntitySymbol symbol : entitySymbolArray) {
            if (input.equals(symbol.toString())) {
                return symbol;
            }
        }
        return null;
    }

    public static EntitySymbol entityType() {
        while (true) {
            String input = scanner.nextLine();
            if (Validator.validateForEntitySymbolInput(input)) {
                return getEntitySymbolFromInput(input);
            } else {
                System.out.println(INVALID_INPUT_CAPTION);
            }
        }
    }

    public static void cleanBuffer() {
        scanner.nextLine();
    }
}
