package com.example.demo.esb.factory;

import com.example.demo.esb.response.EsbCalculateRespose;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EsbCalculateForUrlOneResponseFactory {

    private static List<String> stringsFromUrlRespons = new ArrayList();

    static {
        stringsFromUrlRespons.add("two");
        stringsFromUrlRespons.add("three");
        stringsFromUrlRespons.add("five");
        stringsFromUrlRespons.add("seven");
        stringsFromUrlRespons.add("eleven");
        stringsFromUrlRespons.add("thirteen");
    }

    public
    EsbCalculateRespose create() {
        return EsbCalculateRespose.builder()
                .strings(stringsFromUrlRespons)
                .build();
    }
}
