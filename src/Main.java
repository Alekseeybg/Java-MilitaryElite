import models.Mission;
import models.MissionImpl;
import models.Repair;
import models.RepairImpl;
import soldiers.*;
import soldiers.Interfaces.LieutenantGeneral;
import soldiers.Interfaces.Soldier;
import soldiers.enums.Corps;
import soldiers.enums.MissionState;
import utils.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        List<Soldier> privates = new ArrayList<>();

        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");

            String soldierType = tokens[0];
            int id = Integer.parseInt(tokens[1]);
            String firstName = tokens[2];
            String lastName = tokens[3];

            Soldier soldier = null;
            switch (soldierType) {

                case "Private":
                    double salary = Double.parseDouble(tokens[4]);
                    soldier = new PrivateImpl(id, firstName, lastName, salary);
                    break;
                case "LieutenantGeneral":
                    salary = Double.parseDouble(tokens[4]);
                    LieutenantGeneral lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, salary);

                    for (int i = 5; i < tokens.length; i++) {
                        int wantedId = Integer.parseInt(tokens[i]);
                        for (Soldier soldier1 : privates) {
                            if (soldier1.getId() == wantedId) {
                                lieutenantGeneral.addPrivate(soldier1);
                            }
                        }
                    }
                    soldier = lieutenantGeneral;
                    break;
                case "Engineer":
                    salary = Double.parseDouble(tokens[4]);
                    try {
                        Validator.corps(tokens[5]);
                        Repair[] repairs = new Repair[(tokens.length - 6) / 2];
                        int index = 0;
                        for (int i = 6; i < tokens.length; i += 2) {
                            repairs[index++] = new RepairImpl(tokens[i], Integer.parseInt(tokens[i + 1]));
                        }

                        Corps corps = tokens[5].equals(Corps.AIRFORCE.getName())
                                ? Corps.AIRFORCE : Corps.MARINES;

                        soldier = new EngineerImpl(id, firstName, lastName, salary, corps, repairs);

                    } catch (IllegalArgumentException e) {
                        line = sc.nextLine();
                        continue;
                    }
                    break;
                case "Commando":
                    salary = Double.parseDouble(tokens[4]);
                    try {
                        Validator.corps(tokens[5]);
                        Corps corps = tokens[5].equals(Corps.AIRFORCE.getName())
                                ? Corps.AIRFORCE : Corps.MARINES;

                        Mission[] missions = new Mission[(tokens.length - 6) / 2];
                        int index = 0;
                        for (int i = 6; i < tokens.length; i += 2) {
                            boolean isValid = Validator.mission(tokens[i + 1]);
                            if (isValid) {
                                MissionState state =
                                        tokens[i + 1].equals(MissionState.FINISHED.getState())
                                                ? MissionState.FINISHED : MissionState.IN_PROGRESS;

                                missions[index++] = new MissionImpl(tokens[i], state);
                            }
                        }
                        soldier = new CommandoImpl(id, firstName, lastName, salary, corps, missions);

                    } catch (IllegalArgumentException e) {
                        line = sc.nextLine();
                        continue;
                    }
                    break;
                case "Spy":
                    soldier = new SpyImpl(id, firstName, lastName, tokens[4]);
                    break;
                default:
            }
            if (soldier != null) {
                privates.add(soldier);
            }
            line = sc.nextLine();
        }

        for (Soldier soldier : privates) {
            System.out.println(soldier.toString());
        }
    }
}