package com.example.demo.esb;

import com.example.demo.esb.request.EsbCalculateRequestWrapper;
import com.example.demo.esb.response.EsbCalculateForUrlOneResposeWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name = "esb", url = "{esbOne.url}", configuration = EsbOneConfig.class, fallbackFacktory = EsbFallBFactory.class)
public
interface EsbResourceForServerOne {

    @GetMapping("/primes")
    EsbCalculateForUrlOneResposeWrapper generateDataForUrlOne(@RequestBody EsbCalculateRequestWrapper esbCalculateRequestWrapper);
}