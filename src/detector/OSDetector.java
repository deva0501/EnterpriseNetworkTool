package detector;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OSDetector {

    public String detectOS(String ip) {

        String operatingSystem = "Unknown";

        try {

            ProcessBuilder builder = new ProcessBuilder(
                    "nmap",
                    "-Pn",
                    "-O",
                    ip
            );

            Process process = builder.start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );

            String line;

            while ((line = reader.readLine()) != null) {


                if (line.startsWith("Running:")) {

                    operatingSystem = line.replace("Running:", "").trim();
                    break;
                }

                if (line.startsWith("Aggressive OS guesses:")) {

                    String os = line.replace(
                            "Aggressive OS guesses:",
                            ""
                    ).trim();

                    if (os.contains(",")) {

                        operatingSystem =
                                os.substring(0, os.indexOf(","));

                    } else {

                        operatingSystem = os;
                    }

                    break;
                }
            }

            process.waitFor();

        }

        catch (Exception e) {

            e.printStackTrace();

        }

        return operatingSystem;

    }

}