package com.example.demo.esb.factory;

import com.example.demo.esb.request.EsbCalculateRequest;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EsbCalculateRequestFactory {

    public EsbCalculateRequest create(String url) {
        return EsbCalculateRequest.builder()
                .testUrl(url)
                .build();
    }
}
