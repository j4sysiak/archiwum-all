package com.example.demo

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper

class TestChannelUnmarshaller {

    ObjectMapper mapper = new ObjectMapper();

    def unmarshall(String resource, Class klazz) {
        def res = this.class.getClassLoader().getResource(resource)
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        mapper.readValue(res, klazz)
        }
    }
