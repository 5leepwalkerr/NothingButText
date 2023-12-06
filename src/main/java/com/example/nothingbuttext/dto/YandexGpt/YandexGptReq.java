package com.example.nothingbuttext.dto.YandexGpt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class YandexGptReq {
    private String model;
    private YandexGptGenerationOptions generationOptions;
    private YandexGptMessages messages;
    private String instructionText;

}
