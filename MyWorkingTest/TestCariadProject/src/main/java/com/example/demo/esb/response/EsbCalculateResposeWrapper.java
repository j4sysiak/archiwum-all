package com.example.demo.esb.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EsbCalculateResposeWrapper {

    private EsbCalculateRespose esbCalculateRespose;
}