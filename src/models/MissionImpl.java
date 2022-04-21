package models;

import soldiers.enums.MissionState;

public class MissionImpl implements Mission {
    private final String codeName;
    private MissionState state;

    public MissionImpl(String name, MissionState state) {
        this.codeName = name;
        this.state = state;
    }

    @Override
    public void completeMission() {
        this.state = MissionState.FINISHED;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.codeName, this.state.getState());
    }
}