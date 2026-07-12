package security;

public class SecurityAnalyzer {

    public void analyze(String scanResult) {

        System.out.println();
        System.out.println("==============================================");
        System.out.println("Security Assessment");
        System.out.println("==============================================");

        int riskScore = 0;

        if (scanResult.contains("21/tcp")) {
            System.out.println("[HIGH] FTP service detected.");
            System.out.println("       Recommendation: Disable FTP or use SFTP.");
            riskScore += 3;
        }

        if (scanResult.contains("23/tcp")) {
            System.out.println("[HIGH] Telnet detected.");
            System.out.println("       Recommendation: Replace with SSH.");
            riskScore += 3;
        }

        if (scanResult.contains("80/tcp")) {
            System.out.println("[LOW] HTTP service detected.");
            System.out.println("      Recommendation: Use HTTPS if possible.");
            riskScore += 1;
        }

        if (scanResult.contains("135/tcp")) {
            System.out.println("[MEDIUM] Windows RPC service detected.");
            System.out.println("         Recommendation: Restrict unnecessary access.");
            riskScore += 2;
        }

        if (scanResult.contains("139/tcp")) {
            System.out.println("[MEDIUM] NetBIOS detected.");
            System.out.println("         Recommendation: Disable if not required.");
            riskScore += 2;
        }

        if (scanResult.contains("445/tcp")) {
            System.out.println("[MEDIUM] SMB File Sharing detected.");
            System.out.println("         Recommendation: Keep SMB patched and restrict access.");
            riskScore += 2;
        }

        if (scanResult.contains("3389/tcp")) {
            System.out.println("[HIGH] Remote Desktop detected.");
            System.out.println("       Recommendation: Protect with MFA and firewall rules.");
            riskScore += 3;
        }

        if (scanResult.contains("443/tcp")) {
            System.out.println("[INFO] HTTPS service detected.");
        }

        System.out.println();
        System.out.println("----------------------------------------------");

        if (riskScore >= 8) {
            System.out.println("Overall Risk Level : HIGH");
        }
        else if (riskScore >= 4) {
            System.out.println("Overall Risk Level : MEDIUM");
        }
        else if (riskScore > 0) {
            System.out.println("Overall Risk Level : LOW");
        }
        else {
            System.out.println("Overall Risk Level : SAFE");
        }

        System.out.println("----------------------------------------------");
    }
}