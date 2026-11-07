
package com.ece.maintenance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReportGenerator {

    public static void generateReport(List<Machine> machines) {

        StringBuilder html = new StringBuilder();

        html.append("""
                <html>
                <head>
                <title>Industrial Machine Maintenance Report</title>
                <style>
                body { font-family: Arial; margin: 30px; }
                table { border-collapse: collapse; width: 100%; }
                th, td { border: 1px solid black; padding: 10px; }
                th { background-color: #333; color: white; }
                </style>
                </head>
                <body>
                <h1>Industrial Predictive Maintenance Report</h1>
                <table>
                <tr>
                <th>Machine ID</th>
                <th>Temperature</th>
                <th>Vibration</th>
                <th>Current</th>
                <th>Operating Hours</th>
                <th>Health Score</th>
                <th>Status</th>
                <th>Recommendation</th>
                </tr>
                """);

        for (Machine machine : machines) {

            double score =
                    MaintenanceAnalyzer.calculateHealthScore(machine);

            String status =
                    MaintenanceAnalyzer.getMachineStatus(score);

            String recommendation =
                    MaintenanceAnalyzer.getMaintenanceRecommendation(status);

            html.append("<tr>")
                .append("<td>").append(machine.getMachineId()).append("</td>")
                .append("<td>").append(machine.getTemperature()).append("</td>")
                .append("<td>").append(machine.getVibration()).append("</td>")
                .append("<td>").append(machine.getCurrent()).append("</td>")
                .append("<td>").append(machine.getOperatingHours()).append("</td>")
                .append("<td>").append(String.format("%.2f", score)).append("%</td>")
                .append("<td>").append(status).append("</td>")
                .append("<td>").append(recommendation).append("</td>")
                .append("</tr>");
        }

        html.append("""
                </table>
                </body>
                </html>
                """);

        try {
            Files.createDirectories(Path.of("reports"));

            Files.writeString(
                Path.of("reports/maintenance-report.html"),
                html.toString()
            );

            System.out.println("HTML Report Generated Successfully!");

        } catch (IOException e) {
            System.out.println("Report generation failed: " + e.getMessage());
        }
    }
}
