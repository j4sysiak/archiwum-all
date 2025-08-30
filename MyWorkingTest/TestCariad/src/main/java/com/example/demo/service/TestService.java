package com.example.demo.service;

import com.example.demo.port.in.TestInPort;
import com.example.demo.port.in.TestInRequest;
import com.example.demo.port.in.TestInResponse;
import com.example.demo.port.out.TestOutPort;
import com.example.demo.port.out.TestOutRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class TestService implements TestInPort {

    private final TestOutPort testOutPort;

    @Override
    public
    TestInResponse getTestData(TestInRequest testInRequest) {
        TestOutRequest testOutRequest = TestOutRequest.builder()
                .names(testInRequest.getNames())
                .build();
        return testOutPort.generateData(testOutRequest);
    }
}
