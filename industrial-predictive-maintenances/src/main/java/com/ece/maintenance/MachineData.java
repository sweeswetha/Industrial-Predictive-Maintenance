
package com.ece.maintenance;

import java.util.ArrayList;
import java.util.List;

public class MachineData {

    public static List<Machine> getMachines() {

        List<Machine> machines = new ArrayList<>();

        machines.add(new Machine("M001", 45, 2.0, 15, 2000));
        machines.add(new Machine("M002", 85, 7.5, 38, 7500));
        machines.add(new Machine("M003", 110, 9.0, 48, 9500));
        machines.add(new Machine("M004", 35, 1.5, 10, 1000));
        machines.add(new Machine("M005", 95, 8.5, 45, 8500));

        return machines;
    }
}
