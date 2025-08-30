package com.example.demo.esb;

import com.example.demo.esb.request.EsbCalculateRequestWrapper;
import com.example.demo.esb.response.EsbCalculateForUrlTwoResposeWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name = "esb", url = "{esbTwourl}", configuration = EsbOneConfig.class, fallbackFacktory = EsbFallBFactory.class)
public
interface EsbResourceForServerTwo {

    @GetMapping("/fibo")
    EsbCalculateForUrlTwoResposeWrapper generateDataForUrlTwo(@RequestBody EsbCalculateRequestWrapper esbCalculateRequestWrapper);
}