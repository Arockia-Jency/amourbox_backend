package com.jency.amourboxbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CapsuleResponseDto {
    private String message;
    private String mood;
}
