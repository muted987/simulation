package main.java.com.muted987.Action;

import main.java.com.muted987.InputUtils;

public class MainMenuRender {
    private final String START_APPLICATION_MESSAGE = "=======SIMULATION=======\n1. Start simulation\n2. Settings\n3. Exit";
    private final String START_APPLICATION_OPTION = "1";
    private final String SETTINGS_APPLICATION_OPTION = "2";
    private final String EXIT_APPLICATION_OPTION = "3";

    public String mainMenuRender(){
        System.out.println(START_APPLICATION_MESSAGE);
        return InputUtils.inputString();
    }

}
