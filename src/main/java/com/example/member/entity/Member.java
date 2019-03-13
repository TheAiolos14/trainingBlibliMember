package com.example.member.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @NotBlank
    private String idMember;

    @NotBlank
    private String nameMember;

    @Email
    @NotBlank
    private String emailMember;
}
