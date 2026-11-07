
package com.ece.maintenance;

public class Machine {

    private String machineId;
    private double temperature;
    private double vibration;
    private double current;
    private double operatingHours;

    public Machine(String machineId, double temperature,
                   double vibration, double current,
                   double operatingHours) {

        this.machineId = machineId;
        this.temperature = temperature;
        this.vibration = vibration;
        this.current = current;
        this.operatingHours = operatingHours;
    }

    public String getMachineId() {
        return machineId;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getVibration() {
        return vibration;
    }

    public double getCurrent() {
        return current;
    }

    public double getOperatingHours() {
        return operatingHours;
    }
}
