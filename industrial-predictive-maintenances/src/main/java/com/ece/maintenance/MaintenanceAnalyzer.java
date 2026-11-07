
package com.ece.maintenance;

public class MaintenanceAnalyzer {

    public static double calculateHealthScore(Machine machine) {

        double temperatureRisk =
                Math.min(machine.getTemperature() / 120.0 * 100, 100);

        double vibrationRisk =
                Math.min(machine.getVibration() / 10.0 * 100, 100);

        double currentRisk =
                Math.min(machine.getCurrent() / 50.0 * 100, 100);

        double hoursRisk =
                Math.min(machine.getOperatingHours() / 10000.0 * 100, 100);

        double totalRisk =
                (temperatureRisk * 0.30) +
                (vibrationRisk * 0.30) +
                (currentRisk * 0.20) +
                (hoursRisk * 0.20);

        return 100 - totalRisk;
    }

    public static String getMachineStatus(double score) {

        if (score >= 80) {
            return "Healthy";
        } else if (score >= 50) {
            return "Warning";
        } else {
            return "Critical";
        }
    }

    public static String getMaintenanceRecommendation(String status) {

        if (status.equals("Healthy")) {
            return "Machine operating normally";
        } else if (status.equals("Warning")) {
            return "Schedule machine inspection";
        } else {
            return "Immediate maintenance required";
        }
    }
}
