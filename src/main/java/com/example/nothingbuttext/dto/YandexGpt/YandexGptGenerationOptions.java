package com.example.nothingbuttext.dto.YandexGpt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

public class YandexGptGenerationOptions {
    public YandexGptGenerationOptions(boolean partialResults, double temperature, int maxTokens) {
        this.partialResults = partialResults;
        this.temperature = temperature;
        this.maxTokens = maxTokens;
    }
    private boolean partialResults;

    public void setPartialResults(boolean partialResults) {
        this.partialResults = partialResults;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setMaxTokens(int maxTokens) {
        this.maxTokens = maxTokens;
    }

    public boolean isPartialResults() {
        return partialResults;
    }

    public double getTemperature() {
        return temperature;
    }

    public int getMaxTokens() {
        return maxTokens;
    }

    private double temperature; //Should be a double number between 0 (inclusive) and 1 (inclusive)
    private int maxTokens;
}
