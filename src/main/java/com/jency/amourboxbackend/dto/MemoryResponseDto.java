package com.jency.amourboxbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemoryResponseDto {
    private String title;
    private String description;
    private LocalDate memoryDate;
    private String imageUrl;
}