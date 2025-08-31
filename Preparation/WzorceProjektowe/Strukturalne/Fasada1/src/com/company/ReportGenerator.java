package com.company;

import java.util.Collection;

public class ReportGenerator {

    public void generateReport (Collection<String> qualityScannerError, Collection<String> securityScannerError,
                                Collection<String> dependencyScannerError) {

        System.out.println("qualityScannerError: ");
        System.out.println(String.join(",", qualityScannerError));

        System.out.println("securityScannerError: ");
        System.out.println(String.join(",", securityScannerError));

        System.out.println("dependencyScannerError: ");
        System.out.println(String.join(",", dependencyScannerError));
    }
}
