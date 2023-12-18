package com.example.nothingbuttext.controller;

import com.example.nothingbuttext.dto.YandexGpt.YandexGptReq;
import com.example.nothingbuttext.service.YandexGptActions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.management.monitor.MonitorNotification;

@RestController
@RequestMapping("/convert")
public class VideoToTextController {
    @Autowired
    private YandexGptActions yandexGptActions;

    /*@PostMapping("/video-to-text")
    public ResponseEntity<?> sendDataToYandexGpt(@RequestBody String ytUrl){

    }*/

    @PostMapping("/send-req")
    public Mono<String> sendAsyncPostReq(@RequestBody String link){
       YandexGptReq req=yandexGptActions.createYandexGptReq(link);
        return yandexGptActions.sendReqToYandexGpt(req);
    }

}
