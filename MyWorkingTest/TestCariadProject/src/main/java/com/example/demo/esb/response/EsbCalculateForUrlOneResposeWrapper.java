package com.example.demo.esb.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EsbCalculateForUrlOneResposeWrapper implements Serializable {

    @JsonProperty("docStringsForUrlOneResponse")
    private EsbCalculateRespose esbCalculateRespose;
}
