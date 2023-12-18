package com.example.nothingbuttext.dto.YandexGpt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class YandexGptGenerationOptions {
    private boolean partialResults;

    public YandexGptGenerationOptions(boolean partialResults, double temperature, int maxTokens) {
        this.partialResults = partialResults;
        this.temperature = temperature;
        this.maxTokens = maxTokens;
    }

    private double temperature; //Should be a double number between 0 (inclusive) and 1 (inclusive)
    private int maxTokens;
}
