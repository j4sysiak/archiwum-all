package com.company;

// zadanie fasady: agregacja czterech elementów i rozdzielenie zadań, które one (te obiekty) wykonują.
// fasada ukrywa imlementacyjne skanowania i generowania raportu w metodzie scan
// klient, korzystający z tej fasady, po prostu przekaże tylko urla i już.

import java.util.Collection;

public class ScanFasade {

    // tworzymy obiekty wszystkich typów skanowania i raportowania
    private QualityScanner qualityScanner = new QualityScanner();
    private SecurityScanner securityScanner = new SecurityScanner();
    private DependencyScanner dependencyScanner = new DependencyScanner();
    private ReportGenerator reportGenerator = new ReportGenerator();

    public void scan(String url) {

        System.out.println("Scanning ... " + url);
        Collection<String> qualityScannerError = qualityScanner.qualityScanner(url);
        Collection<String> securityScannerError = securityScanner.securityScanner(url);
        Collection<String> dependencyScannerError = dependencyScanner.dependencyScanner(url);

        //mając skany, jesteśmy w stanie wygenerować raport
        System.out.println("Scan report");
        reportGenerator.generateReport(qualityScannerError, securityScannerError, dependencyScannerError);
    }
}
