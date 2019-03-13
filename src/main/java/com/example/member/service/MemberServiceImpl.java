package com.example.member.service;

import com.example.member.entity.Member;
import com.example.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@Component
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;
    private Mono<Member> list = new Mono<Member>() {
        @Override
        public void subscribe(CoreSubscriber<? super Member> coreSubscriber) {

        }
    };

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository= memberRepository;
    }

    @Override
    public Mono<Member> save(Member member){
        return memberRepository.save(member);
    }

    @Override
    public Flux<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Mono<Member> create(Member member) {

        list.subscribe();
        return null;

    }

    @Override
    public Mono<Member> update(Member member) {

        list.subscribe();
        return null;
    }

    @Override
    public Mono<Member> delete(Member member) {

        return null;
    }


}
