package com.example.demo.esb.service;

import com.example.demo.common.enums.EsbUrlMappingType;
import com.example.demo.esb.EsbResourceForServerOne;
import com.example.demo.esb.EsbResourceForServerTwo;
import com.example.demo.esb.factory.EsbCalculateRequestFactory;
import com.example.demo.esb.request.EsbCalculateRequestWrapper;
import com.example.demo.esb.response.EsbCalculateForUrlOneResposeWrapper;
import com.example.demo.esb.response.EsbCalculateForUrlTwoResposeWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.common.enums.EsbUrlMappingType.URL_ONE;
import static com.example.demo.common.enums.EsbUrlMappingType.URL_TWO;

@Service
@RequiredArgsConstructor
public
class EsbCalculateService {

    private final EsbResourceForServerOne esbResourceForServerOne;
    private final EsbResourceForServerTwo esbResourceForServerTwo;
    private final EsbCalculateRequestFactory esbCalculateRequestFactory;
    private EsbCalculateForUrlOneResposeWrapper esbCalculateForUrlOneResposeWrapper;
    private EsbCalculateForUrlTwoResposeWrapper esbCalculateForUrlTwoResposeWrapper;
    private List<String> stringsFromEachResponse;

    public
    List<String> generateData(EsbUrlMappingType esbUrlMappingType) throws RuntimeException {
        initializeTabs();
        switch (esbUrlMappingType) {
            case URL_ONE:
                //throw new EsbComunicationException("BREAKING TEST FOR URL_ONE");
                esbCalculateForUrlOneResposeWrapper = esbResourceForServerOne
                        .generateDataForUrlOne(EsbCalculateRequestWrapper.builder()
                                                       .esbCalculateRequest(esbCalculateRequestFactory.create(URL_ONE.toString()))
                                                       .build());
                if (esbCalculateForUrlOneResposeWrapper != null &&
                        !esbCalculateForUrlOneResposeWrapper.getEsbCalculateRespose().getStrings().isEmpty()) {
                    stringsFromEachResponse.addAll(esbCalculateForUrlOneResposeWrapper.getEsbCalculateRespose().getStrings());
                }
                break;
            case URL_TWO:
                //throw new EsbComunicationException("BREAKING TEST FOR URL_TWO");
                esbCalculateForUrlTwoResposeWrapper = esbResourceForServerTwo
                        .generateDataForUrlTwo(EsbCalculateRequestWrapper.builder()
                                                       .esbCalculateRequest(esbCalculateRequestFactory.create(URL_TWO.toString()))
                                                       .build());
                if (esbCalculateForUrlTwoResposeWrapper != null &&
                        !esbCalculateForUrlTwoResposeWrapper.getEsbCalculateRespose().getStrings().isEmpty()) {
                    stringsFromEachResponse.addAll(esbCalculateForUrlTwoResposeWrapper.getEsbCalculateRespose().getStrings());
                }
                break;
            default:
                throw new IllegalArgumentException("Unexpected enum constant: " + esbUrlMappingType.getUrlType());
        }
        return stringsFromEachResponse;
    }

    private
    void initializeTabs() {
        stringsFromEachResponse = new ArrayList();
    }
}
