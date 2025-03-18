package com.example.demo.kafka.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.member.dto.MemberDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KafkaService {

    private final KafkaTemplate<String, MemberDto> kafkaTemplate;
    
    public void send(MemberDto memberDto) {
        kafkaTemplate.send("test", memberDto);
    }
}
