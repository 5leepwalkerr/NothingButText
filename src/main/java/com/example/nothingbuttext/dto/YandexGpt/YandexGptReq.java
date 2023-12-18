package com.example.nothingbuttext.dto.YandexGpt;

import lombok.*;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Component;

public class YandexGptReq {
    private String model;
    private YandexGptGenerationOptions generationOptions;
    private YandexGptMessages messages;
    private String instructionText;

    public YandexGptReq(String model, YandexGptGenerationOptions generationOptions, YandexGptMessages messages, String instructionText) {
        this.model = model;
        this.generationOptions = generationOptions;
        this.messages = messages;
        this.instructionText = instructionText;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setGenerationOptions(YandexGptGenerationOptions generationOptions) {
        this.generationOptions = generationOptions;
    }

    public void setMessages(YandexGptMessages messages) {
        this.messages = messages;
    }

    public void setInstructionText(String instructionText) {
        this.instructionText = instructionText;
    }

    public String getModel() {
        return model;
    }

    public YandexGptGenerationOptions getGenerationOptions() {
        return generationOptions;
    }

    public YandexGptMessages getMessages() {
        return messages;
    }

    public String getInstructionText() {
        return instructionText;
    }
}
