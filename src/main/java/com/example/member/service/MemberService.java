package com.example.member.service;

import com.example.member.entity.Member;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MemberService {

    Mono<Member> save(Member member);
    Flux<Member> findAll();
    Mono<Member> create(Member member);
    Mono<Member> update(Member member);
    Mono<Member> delete(Member member);

}
