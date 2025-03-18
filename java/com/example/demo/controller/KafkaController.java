package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.kafka.service.KafkaService;
import com.example.demo.member.dto.MemberDto;

@RestController
@RequestMapping("/kafka/member")
public class KafkaController {

    @Autowired
    private KafkaService kafkaService;
    
    @PostMapping
    public ResponseEntity<String> save(@RequestBody MemberDto memberDto) {
        kafkaService.send(memberDto);
        return ResponseEntity.ok("send");
    }
}
