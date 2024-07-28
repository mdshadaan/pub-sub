package com.shadaan.pub_sub.controller;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shadaan5212
 **/

@RestController
@RequestMapping("api/send")
public class PublishMessageController {

    private final StreamBridge streamBridge;

    public PublishMessageController(StreamBridge streamBridge){
        this.streamBridge = streamBridge;
    }

    @GetMapping
    public ResponseEntity<String> publishMessage(@RequestParam String message){
       streamBridge.send("publish-topic",message);
       return ResponseEntity.ok("ok");
    }
}
