# Enterprise Network Discovery Tool

## Overview

The Enterprise Network Discovery Tool is a Java-based network scanning application that automates network discovery, port scanning, operating system detection, basic security assessment, and CSV report generation. It integrates with Nmap to collect network information and present it in a simple, structured format.

This project demonstrates the practical application of Java in networking by interacting with external networking tools, processing scan results, and generating reports for network administrators and security analysts.

---

## Features

- Network host discovery using Nmap
- Fast TCP port scanning
- Operating system detection
- Basic security risk analysis
- Device inventory generation
- CSV report generation
- Java ProcessBuilder integration with Nmap
- Structured console output
- Object-Oriented Design

---

## Technologies Used

- Java 21
- IntelliJ IDEA
- Nmap
- Git
- GitHub

---

## Project Structure

```
EnterpriseNetworkTool
│
├── src
│   ├── detector
│   │   └── OSDetector.java
│   │
│   ├── model
│   │   └── Device.java
│   │
│   ├── report
│   │   └── CSVReportGenerator.java
│   │
│   ├── scanner
│   │   ├── NetworkScanner.java
│   │   └── PortScanner.java
│   │
│   ├── security
│   │   └── SecurityAnalyzer.java
│   │
│   └── Main.java
│
├── README.md
└── .gitignore
```

---

## Requirements

Before running the project, ensure the following are installed:

- Java JDK 21 or later
- IntelliJ IDEA (or any Java IDE)
- Nmap

Verify Nmap installation:

```
nmap --version
```

---

## Installation

Clone the repository.

```bash
git clone https://github.com/deva0501/EnterpriseNetworkTool.git
```

Open the project in IntelliJ IDEA.

Ensure Nmap is installed and available in the system PATH.

Run the Main.java file.

---

## Usage

1. Enter a network address or subnet.

Example:

```
10.96.54.0/24
```

2. View the discovered devices.

3. Enter an IP address for a detailed scan.

Example:

```
10.96.54.20
```

4. Review:

- Open ports
- Operating system detection
- Security analysis
- CSV report

---

## Sample Output

### Device Discovery

<img width="1600" height="900" alt="device inventory" src="https://github.com/user-attachments/assets/495e07e3-fb56-48b8-9dfb-6d51578d67ec" />

### Port Scan

<img width="1600" height="900" alt="port scanning" src="https://github.com/user-attachments/assets/db52f30c-2ab4-44e6-8d93-25ffed27cfd5" />

### Security Analysis

<img width="1600" height="900" alt="security analyzing" src="https://github.com/user-attachments/assets/9286a583-745a-4811-ba6b-3a3e7390c457" />

### OS Detection

<img width="1600" height="900" alt="OS-detection" src="https://github.com/user-attachments/assets/c8b0baab-f82f-4874-8e1d-4a598a48f274" />

## Report Generation

The application automatically generates a CSV report containing:

- Hostname
- IP Address
- MAC Address
- Vendor
- Operating System
- Status

<img width="1600" height="900" alt="CSV report" src="https://github.com/user-attachments/assets/c6661c69-600f-4cd5-9925-b8fc8bd824b0" />

---

## Limitations

- Hostname availability depends on DNS or NetBIOS resolution.
- MAC addresses can only be detected for devices on the same local network.
- Operating system detection depends on Nmap fingerprinting accuracy.
- Firewalls may prevent host discovery or port scanning.
- Some devices may appear as "Unknown" due to network restrictions.

---

## Future Enhancements

- Graphical User Interface (GUI)
- Multi-threaded scanning
- Service version detection
- PDF report generation
- Export reports in JSON format
- Network topology visualization
- Vulnerability assessment integration
- Scan history management

---

## Learning Outcomes

This project demonstrates knowledge of:

- Java Programming
- Object-Oriented Programming
- ProcessBuilder
- Network Discovery
- TCP Port Scanning
- Operating System Detection
- File Handling
- CSV Report Generation
- External Tool Integration
- Git and GitHub

---

## Author

**Deva**

Bachelor of Engineering (Electronics and Communication Engineering)

Saveetha Engineering College

GitHub: https://github.com/deva0501

---
