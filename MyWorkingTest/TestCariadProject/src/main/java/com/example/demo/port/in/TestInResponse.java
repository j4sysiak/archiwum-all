package com.example.demo.port.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.SortedSet;

@Data
@AllArgsConstructor(staticName = "of")
@Builder
public class TestInResponse {
    private SortedSet<String> strings;
}
