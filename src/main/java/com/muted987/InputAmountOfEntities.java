package main.java.com.muted987;

import java.util.HashMap;

public class InputAmountOfEntities {
    static public HashMap<String, Integer> inputAmountOfEntities() {
        final String[] ARRAY_OF_ENTITIES_CAPTIONS = new String[]{"Rock", "Tree", "Grass", "Herbivore", "Predator"};
        HashMap<String, Integer> amountOfEntities = new HashMap<>();
        int index = 0;
        final String ERROR_ON_VALIDATION_MESSAGE = "Incorrect input";
        while (index != ARRAY_OF_ENTITIES_CAPTIONS.length) {
            String entityCaption = ARRAY_OF_ENTITIES_CAPTIONS[index];
            int amountOfEntity = 0;
            try {
                System.out.printf("Enter amount of %s\n", entityCaption);
                amountOfEntity = InputUtils.inputInteger();
            } catch (Exception e) {
                System.out.println(ERROR_ON_VALIDATION_MESSAGE);
                continue;
            }
            amountOfEntities.put(entityCaption, amountOfEntity);
            index++;

        }
        return amountOfEntities;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> result = inputAmountOfEntities();
        int a = 123;
    }
}
