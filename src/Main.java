import security.SecurityAnalyzer;
import detector.OSDetector;
import model.Device;
import report.CSVReportGenerator;
import scanner.NetworkScanner;
import scanner.PortScanner;


import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("==============================================");
        System.out.println(" Enterprise Network Discovery Tool");
        System.out.println("==============================================");

        System.out.print("\nEnter Network or IP Address : ");
        String target = input.nextLine();

        NetworkScanner networkScanner = new NetworkScanner();

        List<Device> devices = networkScanner.scanNetwork(target);

        System.out.println("\n==============================================");
        System.out.println("Device Inventory");
        System.out.println("==============================================");

        if (devices.isEmpty()) {

            System.out.println("No devices found.");

        } else {

            int count = 1;

            for (Device device : devices) {

                System.out.println("\nDevice #" + count++);
                System.out.println(device);
                System.out.println("----------------------------------------------");
            }
        }

        CSVReportGenerator csv = new CSVReportGenerator();
        csv.generateReport(devices);

        System.out.print("\nEnter IP Address for Detailed Scan : ");
        String ip = input.nextLine();

        PortScanner portScanner = new PortScanner();

        String scanOutput = portScanner.scanPorts(ip);

        OSDetector detector = new OSDetector();

        String os = detector.detectOS(ip);

        System.out.println("\nDetected Operating System : " + os);

        SecurityAnalyzer analyzer = new SecurityAnalyzer();
        analyzer.analyze(scanOutput);

        input.close();
    }
}