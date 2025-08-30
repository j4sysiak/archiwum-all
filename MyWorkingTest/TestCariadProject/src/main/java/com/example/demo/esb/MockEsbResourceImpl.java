package com.example.demo.esb;

import com.example.demo.esb.factory.EsbCalculateForUrlOneResponseFactory;
import com.example.demo.esb.factory.EsbCalculateForUrlTwoResponseFactory;
import com.example.demo.esb.factory.EsbCalculateResponseFactory;
import com.example.demo.esb.request.EsbCalculateRequestWrapper;
import com.example.demo.esb.response.EsbCalculateForUrlOneResposeWrapper;
import com.example.demo.esb.response.EsbCalculateForUrlTwoResposeWrapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.log4j.Log4j2;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static java.util.Optional.ofNullable;

// mock generated data
@Component
@Builder
@AllArgsConstructor
@Log4j2
public class MockEsbResourceImpl implements EsbResourceForServerOne, EsbResourceForServerTwo  {

    private final EsbCalculateForUrlOneResponseFactory esbCalculateForUrlOneResponseFactory;
    private final EsbCalculateForUrlTwoResponseFactory esbCalculateForUrlTwoResponseFactory;
    private final EsbCalculateResponseFactory esbCalculateResponseFactory;

    public EsbCalculateForUrlOneResposeWrapper generateDataForUrlOne(EsbCalculateRequestWrapper esbCalculateRequestWrapper) {

        EsbCalculateForUrlOneResposeWrapper esbCalculateForUrlOneResposeWrapper = null;
        try {
             esbCalculateForUrlOneResposeWrapper =
                    ofNullable(EsbCalculateForUrlOneResposeWrapper.builder()
                                       .esbCalculateRespose(esbCalculateForUrlOneResponseFactory.create())
                                       .build()).orElseThrow(() -> new Exception());
         //   throw new Exception(BREAKING TEST);
        } catch (Exception rte){
            LoggerFactory.getLogger(MockEsbResourceImpl.class).info("ERROR: MockEsbResourceImpl::generateDataForUrlOne" + rte.getMessage());
        }
        if (esbCalculateForUrlOneResposeWrapper != null &&
                esbCalculateForUrlOneResposeWrapper.getEsbCalculateRespose().getStrings().isEmpty()) {
            try {
                throw new Exception();
            } catch (Exception e) {
                LoggerFactory.getLogger(MockEsbResourceImpl.class).info("ERROR: MockEsbResourceImpl::generateDataForUrlOne: Empty List esbCalculateForUrlOneResposeWrapper" + e.getMessage());
            }
        }
            return esbCalculateForUrlOneResposeWrapper;
    }

    public EsbCalculateForUrlTwoResposeWrapper generateDataForUrlTwo(EsbCalculateRequestWrapper esbCalculateRequestWrapper) {
        EsbCalculateForUrlTwoResposeWrapper esbCalculateForUrlTwoResposeWrapper = null;
        try {
             esbCalculateForUrlTwoResposeWrapper =
                    ofNullable(EsbCalculateForUrlTwoResposeWrapper.builder()
                                       .esbCalculateRespose(esbCalculateForUrlTwoResponseFactory.create())
                                       .build()).orElseThrow(() -> new Exception());
            //   throw new Exception(BREAKING TEST);
        } catch (Exception rte){
            LoggerFactory.getLogger(MockEsbResourceImpl.class).info("ERROR: MockEsbResourceImpl::generateDataForUrlTwo " + rte.getMessage());
        }
        if (esbCalculateForUrlTwoResposeWrapper != null &&
                esbCalculateForUrlTwoResposeWrapper.getEsbCalculateRespose().getStrings().isEmpty()) {
            try {
                throw new Exception();
            } catch (Exception e) {
                LoggerFactory.getLogger(MockEsbResourceImpl.class).info("ERROR: MockEsbResourceImpl::generateDataForUrlTwo: Empty List esbCalculateForUrlTwoResposeWrapper " + e.getMessage());
            }
        }
        return esbCalculateForUrlTwoResposeWrapper;
    }
}
