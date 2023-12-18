package com.example.nothingbuttext.controller;

import com.example.nothingbuttext.service.YandexGptActions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/convert")
public class VideoToTextController {
    @Autowired
    private YandexGptActions yandexGptActions;

    /*@PostMapping("/video-to-text")
    public ResponseEntity<?> sendDataToYandexGpt(@RequestBody String ytUrl){

    }*/
}
