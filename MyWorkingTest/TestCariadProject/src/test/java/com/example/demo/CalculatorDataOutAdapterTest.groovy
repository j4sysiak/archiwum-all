package com.example.demo

import com.example.demo.common.enums.TimeService
import com.example.demo.esb.CalculatorDataOutAdapter
import com.example.demo.esb.EsbResourceForServerOne
import com.example.demo.esb.EsbResourceForServerTwo
import com.example.demo.esb.factory.EsbCalculateForUrlOneResponseFactory
import com.example.demo.esb.factory.EsbCalculateForUrlTwoResponseFactory
import com.example.demo.esb.factory.EsbCalculateRequestFactory
import com.example.demo.esb.factory.EsbCalculateResponseFactory
import com.example.demo.esb.response.EsbCalculateForUrlOneResposeWrapper
import com.example.demo.esb.response.EsbCalculateForUrlTwoResposeWrapper
import com.example.demo.esb.response.EsbCalculateRespose
import com.example.demo.esb.service.EsbCalculateService
import com.example.demo.port.out.TestOutPort
import com.example.demo.port.out.TestOutRequest
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

import java.time.LocalDateTime

public class CalculatorDataOutAdapterTest extends Specification {

    @Subject
    CalculatorDataOutAdapter calculatorDataOutAdapter;
    EsbResourceForServerOne esbResourceForServerOne;
    EsbResourceForServerTwo esbResourceForServerTwo;
    TestOutPort testOutPort;
    TimeService timeService;
    LocalDateTime reqTime = LocalDateTime.of(2022, 5, 4, 1, 12);
    Long currentTimeMillis = 44568545654L;

    TestChannelUnmarshaller unmarshaller = new TestChannelUnmarshaller();

    def setup() {
        esbResourceForServerOne = Mock();
        esbResourceForServerTwo = Mock();
        testOutPort = Mock();
        timeService = Mock();
        timeService.currentLocalDateTime >> reqTime;
        timeService.currentTimeMillis() >> currentTimeMillis;

        EsbCalculateResponseFactory esbCalculateResponseFactory = new EsbCalculateResponseFactory();
        EsbCalculateForUrlOneResponseFactory esbCalculateForUrlOneResponseFactory = new EsbCalculateForUrlOneResponseFactory();
        EsbCalculateForUrlTwoResponseFactory esbCalculateForUrlTwoResponseFactory = new EsbCalculateForUrlTwoResponseFactory();
        EsbCalculateRequestFactory esbCalculateRequestFactory = new EsbCalculateRequestFactory();

        EsbCalculateRespose esbCalculateRespose = new EsbCalculateRespose();
        EsbCalculateForUrlOneResposeWrapper esbCalculateForUrlOneResposeWrapper = new EsbCalculateForUrlOneResposeWrapper(esbCalculateRespose);
        EsbCalculateForUrlTwoResposeWrapper esbCalculateForUrlTwoResposeWrapper = new EsbCalculateForUrlTwoResposeWrapper(esbCalculateRespose);

        //TestService  testService = new TestService(testOutPort);

        EsbCalculateService esbCalculateService = new EsbCalculateService(esbResourceForServerOne,
                esbResourceForServerTwo, esbCalculateRequestFactory, esbCalculateForUrlOneResposeWrapper, esbCalculateForUrlTwoResposeWrapper, new ArrayList<String>());
        calculatorDataOutAdapter = new CalculatorDataOutAdapter(esbCalculateService);
    }

    @Unroll
    def "should get data from ESB"() {
        given:
        def esbResponse = unmarshaller.unmarshall(RESPONSE_FILE, EsbCalculateForUrlOneResposeWrapper.class)
        def expected = createEsbCalculateRespose()

        when:
        def actual = calculatorDataOutAdapter.generateData(TestOutRequest.builder().names().build())

        then:
        1 * esbResourceForServerOne.generateDataForUrlOne(_) >> esbResponse
        expected == actual

        where:
        A | RESPONSE_FILE
        0 | "DocGetResponse.json"
    }

    List<String> createEsbCalculateRespose() {
        return [EsbCalculateForUrlOneResposeWrapper.builder()
                        .esbCalculateRespose(EsbCalculateRespose.builder()
                                .strings(["eight",
                                          "eleven",
                                          "five",
                                          "one",
                                          "seven",
                                          "thirteen",
                                          "three",
                                          "twenty one",
                                          "two"]).build())
                        .build()
        ]
    }
}
