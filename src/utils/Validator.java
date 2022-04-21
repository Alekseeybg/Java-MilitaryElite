package utils;

import soldiers.enums.Corps;
import soldiers.enums.MissionState;

public class Validator {

    private Validator() {

    }

    public static void corps(String corps) {
        if (!corps.equals(Corps.AIRFORCE.getName()) && !corps.equals(Corps.MARINES.getName())) {
            throw new IllegalArgumentException("Invalid Corps");
        }
    }

    public static boolean mission(String state) {
        if (!state.equals(MissionState.IN_PROGRESS.getState())
                && !state.equals(MissionState.FINISHED.getState())) {
            return false;
        }
        return true;
    }
}