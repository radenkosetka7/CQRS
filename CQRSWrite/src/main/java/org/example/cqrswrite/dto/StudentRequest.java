package org.example.cqrswrite.dto;

import java.math.BigDecimal;

public record StudentRequest(String name, String email, BigDecimal avgGrade) {
}
