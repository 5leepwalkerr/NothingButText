package com.example.nothingbuttext.service.impl;

import com.example.nothingbuttext.dto.YandexGpt.YandexGptGenerationOptions;
import com.example.nothingbuttext.dto.YandexGpt.YandexGptMessages;
import com.example.nothingbuttext.dto.YandexGpt.YandexGptReq;
import com.example.nothingbuttext.repo.MajorTextPartRepository;
import com.example.nothingbuttext.service.YTUriActions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YtUriActionsImpl implements YTUriActions {
    private static final String GPT_TEXT_REQUEST = "Выдели главные моменты из этого видео и представь их текстом: ";

    @Autowired
    private MajorTextPartRepository repository;

    @Override
    public YandexGptReq createYandexGptReq(String YTUri) {
       return YandexGptReq
               .builder()
               .model("general")
               .generationOptions(
                       YandexGptGenerationOptions
                               .builder()
                               .partialResults(false)
                               .temperature(1.0)
                               .maxTokens(3000)
                               .build()
               )
               .messages(new YandexGptMessages("user",YTUri))
               .instructionText(GPT_TEXT_REQUEST)
               .build();
    }
}
