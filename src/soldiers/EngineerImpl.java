package soldiers;

import models.Repair;
import soldiers.Interfaces.Engineer;
import soldiers.enums.Corps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private List<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corps corps, Repair... repairs) {
        super(id, firstName, lastName, salary, corps);

        if (repairs != null) {
            this.repairs = new ArrayList<>();
            for (Repair repair : repairs) {
                if (repair != null) {
                    this.repairs.add(repair);
                }
            }
        }

       /* this.repairs = repairs !=null?
                Arrays.asList(repairs):new ArrayList<>();*/
    }
            /*  this.repairs.addAll(Arrays.stream(repairs)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList()));
        } else {
            this.repairs = new ArrayList<>();
        }*/


    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return this.repairs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\n").append("Repairs:").append("\n");
        for (Repair repair : repairs) {
            sb.append("  ").append(repair.toString()).append("\n");
        }
        return sb.toString().trim();
    }
}