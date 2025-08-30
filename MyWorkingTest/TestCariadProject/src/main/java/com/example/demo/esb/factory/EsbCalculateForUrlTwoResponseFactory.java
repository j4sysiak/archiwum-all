package com.example.demo.esb.factory;

import com.example.demo.esb.response.EsbCalculateRespose;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EsbCalculateForUrlTwoResponseFactory {

    private static List<String> stringsFromUrlRespons = new ArrayList();

    static {
        stringsFromUrlRespons.add("one");
        stringsFromUrlRespons.add("one");
        stringsFromUrlRespons.add("two");
        stringsFromUrlRespons.add("three");
        stringsFromUrlRespons.add("five");
        stringsFromUrlRespons.add("eight");
        stringsFromUrlRespons.add("thirteen");
        stringsFromUrlRespons.add("twenty one");
    }

    public
    EsbCalculateRespose create() {
        return EsbCalculateRespose.builder()
                .strings(stringsFromUrlRespons)
                .build();
    }
}
