package com.example.demo.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.demo.member.dto.MemberDto;
import com.example.demo.member.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

    private final MemberService memberService;
    
    @KafkaListener(topics = "test", groupId = "cg-test")
    public void onMessage(ConsumerRecord<String, MemberDto> record) {
        try {
            memberService.save(record.value());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
