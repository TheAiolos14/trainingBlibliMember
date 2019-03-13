package com.example.member;

import com.example.member.entity.Member;
import com.example.member.repository.MemberRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {


    private Member member;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void testFindAll() {

        //categoryRepository.deleteAll().block();

        memberRepository.save(new Member("1", "Saputra", "saputra@gmail.com"));

        memberRepository.save(new Member("2", "Teresa", "teresa@gmail.com"));

        Flux<Member> memmber= memberRepository.findAll();

    }
}
