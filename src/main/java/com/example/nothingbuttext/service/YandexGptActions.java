package com.example.nothingbuttext.service;

import com.example.nothingbuttext.dto.YandexGpt.YandexGptReq;
import reactor.core.publisher.Mono;

import javax.management.monitor.MonitorNotification;

public interface YandexGptActions {
    YandexGptReq createYandexGptReq(String YTUri);
    Mono<String> sendReqToYandexGpt(YandexGptReq req);
}
