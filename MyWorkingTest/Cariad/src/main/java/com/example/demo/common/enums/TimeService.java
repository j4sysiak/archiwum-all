package com.example.demo.common.enums;

import java.time.LocalDate;
import java.time.LocalDateTime;

public
interface TimeService {
    LocalDateTime getCurrentLocalDateTime();
    LocalDate getCurrentLocalDate();
    Long currentTimeMillis();
}
