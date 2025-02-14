package com.muted987.simulation;

public class MenuRender {

    private static final String MENU_CAPTION = "Simulation Game\n1. Start simulation\n2. Exit simulation";
    private static final String PAUSE_MENU_CAPTION = "Simulation Game\n1. Continue simulation\n2. Exit simulation";
    private static final String IN_GAME_MENU_CAPTION = "Simulation game\n1. Make iteration\n2. Pause simulation\n3. Exit simulation";
    private static final String IN_GAME_MENU_FIRST_OPTION_CAPTION = "Making iteration";
    private static final String IN_GAME_MENU_SECOND_OPTION_CAPTION = "Pausing simulation";
    private static final String EXIT_CAPTION = "Shutdown the program";
    private static final int MENU_SECOND_OPTION = 2;
    private static final int IN_GAME_MENU_FIRST_OPTION = 1;
    private static final int IN_GAME_MENU_SECOND_OPTION = 2;
    private static final int IN_GAME_MENU_THIRD_OPTION = 3;

    public static void menuRender() {
        System.out.println(MENU_CAPTION);
    }
    public static void  inGameMenuRender() {
        System.out.println(IN_GAME_MENU_CAPTION);
    }
    public static void pauseMenuRender() {
        System.out.println(PAUSE_MENU_CAPTION);
    }
    public static void renderMenuByOption(int option) {
        if (option == MENU_SECOND_OPTION) {
            System.out.println(EXIT_CAPTION);
        }
    }


    public static void renderInGameMenuByOption(int option) {
        switch (option) {
            case IN_GAME_MENU_FIRST_OPTION:
                System.out.println(IN_GAME_MENU_FIRST_OPTION_CAPTION);
                break;
            case IN_GAME_MENU_SECOND_OPTION:
                System.out.println(IN_GAME_MENU_SECOND_OPTION_CAPTION);
                break;
            case IN_GAME_MENU_THIRD_OPTION:
                System.out.println(EXIT_CAPTION);
                break;
        }
    }

}
