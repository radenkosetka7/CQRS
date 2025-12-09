package org.example.cqrsread.dto;

import java.math.BigDecimal;

public record StudentResponse(Long id, String name, String email, BigDecimal avgGrade) {
}
