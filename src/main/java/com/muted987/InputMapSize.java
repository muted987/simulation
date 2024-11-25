package main.java.com.muted987;

import java.util.Scanner;

public class InputMapSize {
    static public String input() {
        System.out.println("Input map size (ex. 10x15 WxH)");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }
}