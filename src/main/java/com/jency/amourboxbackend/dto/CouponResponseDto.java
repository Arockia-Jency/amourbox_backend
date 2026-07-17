package com.jency.amourboxbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouponResponseDto {
    private Long id;
    private String title;
    private String description;
    private boolean isRedeemed;
}