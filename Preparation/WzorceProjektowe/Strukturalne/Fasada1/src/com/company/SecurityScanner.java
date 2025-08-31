package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class SecurityScanner {

    public Collection<String> securityScanner(String url) {
        System.out.println("SecurityScanner ...");
        return new ArrayList(Arrays.asList("SecErr1", "SecErr2"));
        // lub return Arrays.asList("SecErr1", "SecErr2");
        // lub eturn List.of("SecErr1", "SecErr2");
    }
}
