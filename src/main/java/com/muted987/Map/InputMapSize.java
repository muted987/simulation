package main.java.com.muted987.Map;

import main.java.com.muted987.InputUtils;

public class InputMapSize {
    static public String inputSizeOfMap() {
        System.out.println("Input map size (ex. 10x15 WxH)");
        final String ERROR_ON_VALIDATION_MESSAGE = "Incorrect input";
        while (true) {
            try {
                return InputUtils.inputString();
            } catch (Exception e) {
                System.out.println(ERROR_ON_VALIDATION_MESSAGE);
            }
            break;
        }
        return "";
    }
}