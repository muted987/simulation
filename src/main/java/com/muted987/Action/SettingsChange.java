package main.java.com.muted987.Action;

import main.java.com.muted987.InputUtils;

import java.util.HashMap;

public class SettingsChange {

    public void changeAmount(String key, HashMap<String, Integer> amountOfEntitiesOnMap) {
        int inputAmount = InputUtils.inputInteger();
        amountOfEntitiesOnMap.replace(key, amountOfEntitiesOnMap.get(key), inputAmount);
    }
    public void changeMoveSpeed(String key, HashMap<String, Integer> moveSpeedSettings) {
        int inputMoveSpeed = InputUtils.inputInteger();
        moveSpeedSettings.replace(key, moveSpeedSettings.get(key), inputMoveSpeed);
    }
    public void changeEveryAmount(HashMap<String, Integer> amountOfEntitiesOnMap) {
        String[] arrayOfKeys = amountOfEntitiesOnMap.keySet().toArray(new String[0]);
        for (String key : arrayOfKeys) {
            (new SettingsRender()).keysAmountRender(key);
            int inputAmount = InputUtils.inputInteger();
            amountOfEntitiesOnMap.replace(key, amountOfEntitiesOnMap.get(key), inputAmount);
        }
    }


    public void changeEveryMoveSpeed(HashMap<String, Integer> moveSpeedSettings) {
        String[] arrayOfKeys = moveSpeedSettings.keySet().toArray(new String[0]);

        for (String key : arrayOfKeys) {
            String moveSpeedKeyCaption = (key.split("_"))[0];
            (new SettingsRender()).keysMoveSpeedRender(moveSpeedKeyCaption);
            int inputMoveSpeed = InputUtils.inputInteger();
            moveSpeedSettings.replace(key, moveSpeedSettings.get(key), inputMoveSpeed);
        }
    }
}
