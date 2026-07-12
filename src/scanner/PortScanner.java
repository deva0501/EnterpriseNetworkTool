package scanner;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PortScanner {

    public String scanPorts(String ip) {

        StringBuilder output = new StringBuilder();

        try {

            ProcessBuilder builder = new ProcessBuilder(
                    "nmap",
                    "-Pn",
                    "-F",
                    ip
            );

            builder.redirectErrorStream(true);

            Process process = builder.start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );

            String line;
            boolean print = false;

            System.out.println();
            System.out.println("==============================================");
            System.out.println("Port Scan Results");
            System.out.println("==============================================");

            while ((line = reader.readLine()) != null) {

                output.append(line).append("\n");

                if (line.trim().startsWith("PORT")) {
                    print = true;
                    System.out.println(line);
                    continue;
                }

                if (print) {
                    System.out.println(line);
                }
            }

            if (!output.toString().contains("PORT")) {
                System.out.println("No open ports found or all ports are filtered.");
            }

            process.waitFor();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();
    }
}