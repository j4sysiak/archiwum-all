package com.example.demo.esb.factory;

import com.example.demo.esb.response.EsbCalculateRespose;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EsbCalculateResponseFactory {

    public EsbCalculateRespose create(List<String> listOfStringsFromResponses) {
        return EsbCalculateRespose.builder()
                .strings(listOfStringsFromResponses)
                .build();
    }
}
