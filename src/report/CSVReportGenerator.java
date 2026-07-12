package report;

import model.Device;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVReportGenerator {

    public void generateReport(List<Device> devices) {

        try {

            FileWriter writer = new FileWriter("Network_Report.csv");

            writer.write("Hostname,IP Address,MAC Address,Vendor,Operating System,Status\n");

            for (Device device : devices) {

                writer.write(device.getHostname() + ",");
                writer.write(device.getIpAddress() + ",");
                writer.write(device.getMacAddress() + ",");
                writer.write(device.getVendor() + ",");
                writer.write(device.getOperatingSystem() + ",");
                writer.write(device.getStatus() + "\n");

            }

            writer.close();

            System.out.println();
            System.out.println("==============================================");
            System.out.println("CSV Report Generated Successfully");
            System.out.println("File : Network_Report.csv");
            System.out.println("==============================================");

        }

        catch (IOException e) {

            System.out.println("Error generating CSV Report.");

            e.printStackTrace();

        }

    }

}