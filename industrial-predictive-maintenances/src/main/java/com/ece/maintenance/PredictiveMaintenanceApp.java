
package com.ece.maintenance;

import java.util.List;

public class PredictiveMaintenanceApp {

    public static void main(String[] args) {

        List<Machine> machines = MachineData.getMachines();

        System.out.println("==============================================");
        System.out.println(" INDUSTRIAL PREDICTIVE MAINTENANCE SYSTEM");
        System.out.println("==============================================");

        for (Machine machine : machines) {

            double score =
                    MaintenanceAnalyzer.calculateHealthScore(machine);

            String status =
                    MaintenanceAnalyzer.getMachineStatus(score);

            String recommendation =
                    MaintenanceAnalyzer.getMaintenanceRecommendation(status);

            System.out.println("\nMachine ID: " + machine.getMachineId());
            System.out.println("Temperature: " + machine.getTemperature());
            System.out.println("Vibration: " + machine.getVibration());
            System.out.println("Current: " + machine.getCurrent());
            System.out.println("Operating Hours: " + machine.getOperatingHours());
            System.out.printf("Health Score: %.2f%%\n", score);
            System.out.println("Status: " + status);
            System.out.println("Recommendation: " + recommendation);
            System.out.println("----------------------------------------------");
        }
        ReportGenerator.generateReport(machines);
    }
}
