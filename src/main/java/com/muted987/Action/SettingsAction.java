package main.java.com.muted987.Action;

import main.java.com.muted987.InputUtils;

import java.util.HashMap;

public class SettingsAction {

    private final SettingsRender settingsRender = new SettingsRender();
    private final SettingsChange settingsChanger = new SettingsChange();

    public void settingMainChoose(HashMap<String, Integer> amountOfEntitiesOnMap, HashMap<String, Integer> moveSpeedSettings) {
        boolean flag = true;
        while (flag) {
            settingsRender.mainSettingsMessageRender();
            String input = InputUtils.inputString();
            switch (input) {
                case "1":
                    settingsRender.firstOptionMessageRender();
                    String keyOfAmountHashMap = settingsRender.firstOptionRender(InputUtils.inputString());
                    if (keyOfAmountHashMap.equals("all")) {
                        settingsChanger.changeEveryAmount(amountOfEntitiesOnMap);
                    } else {
                        settingsChanger.changeAmount(keyOfAmountHashMap, amountOfEntitiesOnMap);
                    }
                    break;
                case "2":
                    settingsRender.secondOptionMessageRender();
                    String keyOfMoveSpeedHashMap = settingsRender.secondOptionRender(InputUtils.inputString());
                    if (keyOfMoveSpeedHashMap.equals("all")) {
                        settingsChanger.changeEveryMoveSpeed(moveSpeedSettings);
                    } else {
                        settingsChanger.changeMoveSpeed(keyOfMoveSpeedHashMap, moveSpeedSettings);
                    }
                    break;
                case "3":
                    flag = false;
                    break;
            }
        }
    }
}
