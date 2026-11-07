
package com.ece.maintenance;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MaintenanceAnalyzerTest {

    @Test
    public void testHealthyMachine() {

        Machine machine = new Machine("T1", 35, 1.5, 10, 1000);

        double score =
                MaintenanceAnalyzer.calculateHealthScore(machine);

        assertTrue(score >= 80);
        assertEquals("Healthy",
                MaintenanceAnalyzer.getMachineStatus(score));
    }

    @Test
    public void testWarningMachine() {

        Machine machine = new Machine("T2", 60, 4, 25, 4000);

        double score =
                MaintenanceAnalyzer.calculateHealthScore(machine);

        assertTrue(score >= 50 && score < 80);
        assertEquals("Warning",
                MaintenanceAnalyzer.getMachineStatus(score));
    }

    @Test
    public void testCriticalMachine() {

        Machine machine = new Machine("T3", 110, 9.0, 48, 9500);

        double score =
                MaintenanceAnalyzer.calculateHealthScore(machine);

        assertTrue(score < 50);
        assertEquals("Critical",
                MaintenanceAnalyzer.getMachineStatus(score));
    }
}
