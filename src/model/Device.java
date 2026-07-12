package model;

public class Device {

    private String hostname;
    private String ipAddress;
    private String macAddress;
    private String vendor;
    private String operatingSystem;
    private String status;

    public Device(String hostname,
                  String ipAddress,
                  String macAddress,
                  String vendor,
                  String operatingSystem,
                  String status) {

        this.hostname = hostname;
        this.ipAddress = ipAddress;
        this.macAddress = macAddress;
        this.vendor = vendor;
        this.operatingSystem = operatingSystem;
        this.status = status;
    }

    public String getHostname() {
        return hostname;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public String getVendor() {
        return vendor;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {

        return "Hostname         : " + hostname +
                "\nIP Address      : " + ipAddress +
                "\nMAC Address     : " + macAddress +
                "\nVendor          : " + vendor +
                "\nOperating System: " + operatingSystem +
                "\nStatus          : " + status;
    }
}