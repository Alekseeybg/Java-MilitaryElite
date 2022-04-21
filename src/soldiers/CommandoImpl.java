package soldiers;

import models.Mission;
import soldiers.Interfaces.Commando;
import soldiers.enums.Corps;

import java.util.*;
import java.util.stream.Collectors;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private List<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corps corps, Mission... missions) {
        super(id, firstName, lastName, salary, corps);

        if(missions!=null){
            this.missions = new ArrayList<>();
            for (Mission mission : missions) {
                if (mission != null) {
                    this.missions.add(mission);
                }
            }
        }

    }


    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return this.missions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator()).append("Missions:").append(System.lineSeparator());
        for (Mission mission : missions) {
          sb.append("  ").append(mission.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}