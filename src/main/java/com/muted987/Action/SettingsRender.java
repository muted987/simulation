package main.java.com.muted987.Action;


public class SettingsRender {
    final String MAIN_SETTINGS_MESSAGE = "=======Settings=======\n1. Change amount of entities\n2. Change move speed of creatures\n3. Back";
    final String SETTINGS_FIRST_OPTION_MESSAGE = "=======Change amount of entities=======\n1. Rock\n2. Grass\n3. Tree\n4. Herbivore\n5. Predator\n6. Change amount of all entities\n7. Back to main menu";
    final String SETTINGS_SECOND_OPTION_MESSAGE = "=======Change move speed of creatures=======\n1. Change move speed of herbivore\n2. Change move speed of predator\n3. Change move speed of all creatures\n4. Back";

    public void mainSettingsMessageRender() {
        System.out.println(MAIN_SETTINGS_MESSAGE);
    }
    public void firstOptionMessageRender(){
        System.out.println(SETTINGS_FIRST_OPTION_MESSAGE);
    }
    public void secondOptionMessageRender(){
        System.out.println(SETTINGS_SECOND_OPTION_MESSAGE);
    }
    public String firstOptionRender(String option) {
        final String ROCK_INPUT_REQUEST = "Enter amount of Rock";
        final String TREE_INPUT_REQUEST = "Enter amount of Tree";
        final String GRASS_INPUT_REQUEST = "Enter amount of Grass";
        final String HERBIVORE_INPUT_REQUEST = "Enter amount of Herbivore";
        final String PREDATOR_INPUT_REQUEST = "Enter amount of Predator";
        switch (option) {
            case "1":
                System.out.println(ROCK_INPUT_REQUEST);
                return "Rock";
            case "2":
                System.out.println(GRASS_INPUT_REQUEST);
                return "Grass";
            case "3":
                System.out.println(TREE_INPUT_REQUEST);
                return "Tree";
            case "4":
                System.out.println(HERBIVORE_INPUT_REQUEST);
                return "Herbivore";
            case "5":
                System.out.println(PREDATOR_INPUT_REQUEST);
                return "Predator";
            case "6":
                return "all";
        }
        return null;
    }

    public void keysAmountRender(String key) {
        System.out.printf("Enter amount of %s\n", key);
    }

    public void keysMoveSpeedRender(String key) {
        System.out.printf("Enter move speed of %s\n", key);
    }

    public String secondOptionRender(String option) {
        final String HERBIVORE_MOVE_SPEED_REQUEST = "Enter move speed for Herbivore";
        final String PREDATOR_MOVE_SPEED_REQUEST = "Enter move speed for Predator";
        switch (option) {
            case "1":
                System.out.println(HERBIVORE_MOVE_SPEED_REQUEST);
                return "herbivore_MoveSpeed";
            case "2":
                System.out.println(PREDATOR_MOVE_SPEED_REQUEST);
                return "predator_MoveSpeed";
            case "3":
                return "all";
        }
        return null;
    }
}
