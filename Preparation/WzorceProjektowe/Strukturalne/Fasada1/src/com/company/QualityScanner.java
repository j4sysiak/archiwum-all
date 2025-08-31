package com.company;

import java.util.Arrays;
import java.util.Collection;

public class QualityScanner {

    public Collection<String> qualityScanner(String url) {
        System.out.println("qualityScan ...");
        return Arrays.asList("Err1", "Err2");
        // lub return new ArrayList(Arrays.asList("Err1", "Err2"));
        // lub return List.of("Err1", "Err2");
    }
}
