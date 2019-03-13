package com.example.member;

import com.example.member.entity.Member;
import com.example.member.repository.MemberRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberServiceTest {

    private MemberRepository memberRepository;

    @Test
    public void testSave(){
        Member member= new Member(
                "1", "Saputra", "saputra@gmail.com"
        );
        
        memberRepository.save(member).block();
        Member result = memberRepository.findById("1").block();
        Assert.assertNotNull(result);
    }

    @Test
    public void testFindAll(){

        memberRepository.deleteAll().block();

        memberRepository.save(new Member(
                "1", "Saputra Wijaya", "saputra@gmail.123"
        )).block();
        memberRepository.save(new Member(
                "2", "Apple", "MantulBener@gmail.com"
        )).block();

        List<Member> products = memberRepository.findAll().collectList().block();

        Assert.assertTrue(products.size() == 2);
    }
}
