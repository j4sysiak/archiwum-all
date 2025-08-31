package com.company;

import java.util.Collection;
import java.util.List;

public class DependencyScanner {

    public Collection<String> dependencyScanner(String url) {

        System.out.println("DependencyScanner ...");
        return List.of("DecErr1", "DecErr2");
        // lub return Arrays.asList("DecErr1", "DecErr2");
        // lub return new ArrayList(Arrays.asList("DecErr1", "DecErr2"));
    }
}
