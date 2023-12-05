package com.example.nothingbuttext.dto.YandexGpt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YandexGptGenerationOptions {
    private boolean partialResults;
    private double temperature; //Should be a double number between 0 (inclusive) and 1 (inclusive)
    private int maxTokens;
}
