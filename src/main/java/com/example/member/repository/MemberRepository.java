package com.example.member.repository;

import com.example.member.entity.Member;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MemberRepository extends ReactiveMongoRepository<Member,String> {
    Mono<Member> findByEmail(String emailMember);
    Flux<Member> findByName (String nameMember);

}
