package com.example.member.controller;

import com.example.member.entity.Member;
import com.example.member.service.MemberService;
import com.example.member.validation.ValidationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
public class MemberController {

    private MemberService memberService;

    private ValidationHelper validationHelper;

    @Autowired
    public MemberController(MemberService memberService, ValidationHelper validationHelper){
        this.memberService = memberService;
        this.validationHelper = validationHelper;
    }
    @RequestMapping(
            value = "/members",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<Member> save(@RequestBody Member member){
        return validationHelper.validate(member).flatMap(data -> memberService.save(data)).subscribeOn(Schedulers.elastic());
    }

    @RequestMapping(
            value = "/members",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Flux<Member> findAll(){
        return memberService.findAll().subscribeOn(Schedulers.elastic());
    }

}
