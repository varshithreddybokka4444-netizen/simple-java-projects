package com.librarymanagement.service;

import com.librarymanagement.model.Member;
import com.librarymanagement.repository.MemberRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    @Test
    public void shouldAddMember() throws InvalidBookException {
        MemberRepository memberRepository = new MemberRepository();
        MemberService memberService = new MemberService(memberRepository);


        ServiceResult result = memberService.addMember( "Student","Alice", "alice@test.com");
        assertTrue(result.isSuccess());
    }

    @Test
    public void shouldThrowExceptionIfAnyDetailsAreNull(){
        MemberRepository memberRepository = new MemberRepository();
        MemberService memberService = new MemberService(memberRepository);


        assertThrows(Exception.class,()->memberService.addMember(null,"Alice", "alice@test.com"));
    }

}