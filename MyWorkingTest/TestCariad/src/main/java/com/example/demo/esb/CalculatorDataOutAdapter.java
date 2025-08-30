package com.example.demo.esb;

import com.example.demo.common.enums.EsbUrlMappingType;
import com.example.demo.exception.CalculationUrlsException;
import com.example.demo.esb.service.EsbCalculateService;
import com.example.demo.exception.EsbComunicationException;
import com.example.demo.port.in.TestInResponse;
import com.example.demo.port.out.TestOutPort;
import com.example.demo.port.out.TestOutRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Stream;

import static com.example.demo.common.enums.EsbUrlMappingType.URL_ONE;

@Component
@Log4j2
@RequiredArgsConstructor
public
class CalculatorDataOutAdapter implements TestOutPort {

    private final EsbCalculateService esbCalculateService;
    private SortedSet<String> stringsFromAllResponses;
    private List<String> errors;
    private Stream<String> myStream;
    private static final Long SOME_LONG_VALUE = 444444L;
    private static final String URL1 = "http://example.com/primes";
    private static final String URL2 = "http://foobar.com/fibo";

    @Override
    public
    TestInResponse generateData(TestOutRequest testOutRequest) {

      //  simulateTimeOut503();
        initializeVars();
        validateUrls(testOutRequest);
        generateDataFromUrls(testOutRequest);

        if (errors.stream().count() == 1) {
            throw new RuntimeException(errors.get(0));
        } else if (errors.stream().count() > 1) {
            return TestInResponse.builder()
                    .strings(new TreeSet())
                    .build();
        }
        return TestInResponse.builder()
                .strings(stringsFromAllResponses)
                .build();
    }

    private
    void generateDataFromUrls(TestOutRequest testOutRequest) {
        myStream = Stream.of(testOutRequest.getNames());
        myStream.forEach(url -> {
            try {
                generateData(url);
            } catch (Exception e) {
                errors.add("Exception occured: " + url);
            }
        });
    }

    private
    void initializeVars() {
        errors = new ArrayList();
        stringsFromAllResponses = new TreeSet();
    }

    private
    void validateUrls(TestOutRequest testOutRequest) {
        myStream = Stream.of(testOutRequest.getNames());
        myStream.forEach(url -> {
            try {
                validateUrl(url);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });
    }

    private
    void validateUrl(String url) throws Exception {
        isUrlEmptyOrNull(url);
        isUrlValid(url);
        isUrlMatchedToPattern(url);
    }

    private
    void isUrlEmptyOrNull(String url) throws Exception {
        if (url == null || url.length() == 0) {
            String errMessage = "ERROR: URL isUrlEmptyOrNull";
            LoggerFactory.getLogger(CalculatorDataOutAdapter.class).info(errMessage);
            throw new Exception(errMessage);
        }
    }

    private
    void generateData(String url) {
        try {
            List<String> returnedDataList = esbCalculateService.generateData(matchUrlToEnumType(url));
            if (returnedDataList != null && !returnedDataList.isEmpty()) {
                stringsFromAllResponses.addAll(returnedDataList);
            } else {
                errors.add("No values returned from ESB for url: " + url);
            }
        } catch (EsbComunicationException esbExc) {
            throw new CalculationUrlsException("generateData", esbExc);
        }
    }

    private
    void isUrlValid(String url) throws Exception {
        try {
            URL obj = new URL(url);
            obj.toURI();
        } catch (MalformedURLException e) {
            LoggerFactory.getLogger(CalculatorDataOutAdapter.class).info("ERROR (MalformedURLException): " + e.getMessage());
            throw new MalformedURLException(e.getMessage());
        } catch (URISyntaxException e) {
            LoggerFactory.getLogger(CalculatorDataOutAdapter.class).info("ERROR (URISyntaxException): " + e.getMessage());
            throw new URISyntaxException(url, e.getMessage(), -1);
        } catch (Exception e) {
            LoggerFactory.getLogger(CalculatorDataOutAdapter.class).info("ERROR (Exception): " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    private
    void isUrlMatchedToPattern(String url) throws EnumConstantNotPresentException {
        EsbUrlMappingType esbUrlMappingType;
        switch (url) {
            case URL1:
                break;
            case URL2:
                break;
            default:
                esbUrlMappingType = EsbUrlMappingType.URL_NOT_VALID;
                throw new EnumConstantNotPresentException(esbUrlMappingType.getClass(), url);
        }
    }

    private
    EsbUrlMappingType matchUrlToEnumType(String url) throws EnumConstantNotPresentException {
        EsbUrlMappingType esbUrlMappingType;
        switch (url) {
            case URL1:
                esbUrlMappingType = URL_ONE;
                break;
            case URL2:
                esbUrlMappingType = EsbUrlMappingType.URL_TWO;
                break;
            default:
                errors.add("URL not in Enum Type: " + url);
                esbUrlMappingType = EsbUrlMappingType.URL_NOT_VALID;
                throw new EnumConstantNotPresentException(esbUrlMappingType.getClass(), url);
        }
        return esbUrlMappingType;
    }

    private
    void simulateTimeOut503() {
        for (long i = 0; i <= SOME_LONG_VALUE.longValue(); i++) {
            System.out.println("");  //  throw new InterruptedException();
        }
    }
}
