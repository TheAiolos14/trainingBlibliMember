package com.example.member.listener;

import com.example.member.entity.Member;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloListener {

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "categories")
    public void listenTopicBelajar(String body) throws  Exception {
        Member member =  objectMapper.readValue(body, Member.class);
        log.info("Receive Message {}", member);
    }
}
