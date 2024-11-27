package main.java.com.muted987.Action;

import main.java.com.muted987.InputUtils;
import main.java.com.muted987.Map.AmountOfEntitiesOnMap;
import main.java.com.muted987.Map.Map;
import main.java.com.muted987.Map.MapFactory;

import java.util.HashMap;

public class Action {

    public void simulation(Map map) {
        (new ActionRender()).actionMainMenuMessageRender();
        String input = InputUtils.inputString();
        switch (input) {
            case "1":
                nextMove(map);
                break;
            case "2":
                pauseSimulation();
                break;
            case "3":
                System.exit(228);
                break;
        }
    }

    public void nextMove(Map map){
        System.out.println("DO MOVE");
    }

    public Map startSimulation() {
        HashMap<String, Integer> moveSpeedSettings = new HashMap<String, Integer>(){{
            put("predator_MoveSpeed", 1);
            put("herbivore_MoveSpeed", 1);
        }};
        HashMap<String, Integer> amountOfEntitiesOnMap = (new AmountOfEntitiesOnMap()).getAmountOfEntities();
        boolean flag = true;
        while (flag) {
            MainMenuRender mainMenuRender = new MainMenuRender();
            String startSimulationOption = mainMenuRender.mainMenuRender();
            switch (startSimulationOption) {
                case "1":
                    flag = false;
                    break;
                case "2":
                    settingsChange(amountOfEntitiesOnMap, moveSpeedSettings);
                    break;
                case "3":
                    System.exit(1);
            }
        }
        return (new MapFactory()).customMap(amountOfEntitiesOnMap, moveSpeedSettings);
    }

    public void pauseSimulation() {
    }
    public void settingsChange(HashMap<String, Integer> amountOfEntitiesOnMap, HashMap<String, Integer> moveSpeedSettings) {
        SettingsAction settingsAction = new SettingsAction();
        settingsAction.settingMainChoose(amountOfEntitiesOnMap, moveSpeedSettings);


    }
}
