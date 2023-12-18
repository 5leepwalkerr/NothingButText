package com.example.nothingbuttext.service.impl;

import com.example.nothingbuttext.dto.YandexGpt.YandexGptGenerationOptions;
import com.example.nothingbuttext.dto.YandexGpt.YandexGptMessages;
import com.example.nothingbuttext.dto.YandexGpt.YandexGptReq;
import com.example.nothingbuttext.repo.MajorTextPartRepository;
import com.example.nothingbuttext.service.YandexGptActions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class YandexGptActionsImpl implements YandexGptActions {
    private static final String YANDEX_GPT_TEXT_BASE_REQ = "Выдели главные моменты из этого видео и представь их текстом: ";
    private static final String YANDEX_GPT_BASE_URL_ASYNC = "https://llm.api.cloud.yandex.net/foundationModels/v1/completionAsync";
    @Autowired
    private MajorTextPartRepository repository;
    @Autowired
    private WebClient webClient;

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
               .messages(new YandexGptMessages("system",YTUri))
               .instructionText(YANDEX_GPT_TEXT_BASE_REQ)
               .build();
    }

    @Override
    public Mono<String> sendReqToYandexGpt(YandexGptReq req) {
        webClient = WebClient.builder().baseUrl(YANDEX_GPT_BASE_URL_ASYNC).build();
    }
}
