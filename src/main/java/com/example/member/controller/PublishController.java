package com.example.member.controller;


import com.example.member.entity.Member;
import com.example.member.model.ApiKey;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishController {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(
            value = "/publish",
            method = RequestMethod.GET,
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public String publish(ApiKey apiKey)throws Exception{
        Member member= new Member("10","Mainan", "udin@gmail.com");
        String json = objectMapper.writeValueAsString(member);
        kafkaTemplate.send("categories",json);
        return "Success";
    }

}