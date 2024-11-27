package main.java.com.muted987;

import java.util.Scanner;

public class InputUtils {

    static public String inputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    static public int inputInteger() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
