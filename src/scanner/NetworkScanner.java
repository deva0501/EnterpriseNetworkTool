package scanner;

import model.Device;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.List;

public class NetworkScanner {

    public List<Device> scanNetwork(String target) {

        List<Device> devices = new ArrayList<>();

        try {

            ProcessBuilder builder = new ProcessBuilder(
                    "nmap",
                    "-sn",
                    "-PR",
                    target
            );

            builder.redirectErrorStream(true);

            Process process = builder.start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );

            String line;

            String hostname = "Unknown";
            String ip = "";
            String mac = "Unknown";
            String vendor = "Unknown";

            boolean hostFound = false;

            while ((line = reader.readLine()) != null) {

                if (line.startsWith("Nmap scan report for")) {

                    if (hostFound) {

                        devices.add(new Device(
                                hostname,
                                ip,
                                mac,
                                vendor,
                                "Unknown",
                                "Online"
                        ));
                    }

                    hostname = "Unknown";
                    ip = "";
                    mac = "Unknown";
                    vendor = "Unknown";

                    hostFound = true;

                    String value = line.replace("Nmap scan report for", "").trim();

                    if (value.contains("(") && value.contains(")")) {

                        hostname = value.substring(0, value.indexOf("(")).trim();

                        ip = value.substring(
                                value.indexOf("(") + 1,
                                value.indexOf(")")
                        ).trim();

                    } else {

                        ip = value;

                        try {

                            InetAddress address = InetAddress.getByName(ip);

                            String resolved = address.getHostName();

                            if (!resolved.equals(ip)) {
                                hostname = resolved;
                            }

                            NetworkInterface ni =
                                    NetworkInterface.getByInetAddress(address);

                            if (ni != null) {

                                byte[] macBytes = ni.getHardwareAddress();

                                if (macBytes != null) {

                                    StringBuilder sb = new StringBuilder();

                                    for (int i = 0; i < macBytes.length; i++) {

                                        sb.append(String.format(
                                                "%02X%s",
                                                macBytes[i],
                                                (i < macBytes.length - 1) ? ":" : ""
                                        ));
                                    }

                                    mac = sb.toString();
                                }
                            }

                        } catch (Exception ignored) {
                        }
                    }

                }

                else if (line.startsWith("MAC Address:")) {

                    String temp = line.replace("MAC Address:", "").trim();

                    if (temp.contains("(")) {

                        mac = temp.substring(
                                0,
                                temp.indexOf("(")
                        ).trim();

                        vendor = temp.substring(
                                temp.indexOf("(") + 1,
                                temp.indexOf(")")
                        ).trim();

                    } else {

                        mac = temp;
                    }
                }
            }

            if (hostFound) {

                devices.add(new Device(
                        hostname,
                        ip,
                        mac,
                        vendor,
                        "Unknown",
                        "Online"
                ));
            }

            process.waitFor();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return devices;
    }
}