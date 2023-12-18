package com.example.nothingbuttext.service.impl;

import com.example.nothingbuttext.dto.YandexGpt.YandexGptGenerationOptions;
import com.example.nothingbuttext.dto.YandexGpt.YandexGptMessages;
import com.example.nothingbuttext.dto.YandexGpt.YandexGptReq;
import com.example.nothingbuttext.repo.MajorTextPartRepository;
import com.example.nothingbuttext.service.YandexGptActions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class YandexGptActionsImpl implements YandexGptActions {
    private static final String YANDEX_GPT_TEXT_BASE_REQ = "Выдели главные моменты из этого видео и представь их текстом: ";
    @Value("${yandex.baseUrl}")
    private String baseUrl;
    @Autowired
    private MajorTextPartRepository repository;
    private final WebClient webClient;

    // Inject WebClient in the constructor
    public YandexGptActionsImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(baseUrl).build();
    }

    @Override
        public YandexGptReq createYandexGptReq(String YTUri) {
            YandexGptGenerationOptions generationOptions = new YandexGptGenerationOptions(false, 1.0, 3000);

            YandexGptMessages messages = new YandexGptMessages("system", YTUri);

            return new YandexGptReq("general", generationOptions, messages, YANDEX_GPT_TEXT_BASE_REQ);
        }

    @Override
    public Mono<String> sendReqToYandexGpt(YandexGptReq req) {
        String endpointPath = "/foundationModels/v1/completionAsync";
        return webClient
                .post()
                .uri(endpointPath)
                .body(BodyInserters.fromValue(req))
                .retrieve()
                .bodyToMono(String.class);
    }
}
