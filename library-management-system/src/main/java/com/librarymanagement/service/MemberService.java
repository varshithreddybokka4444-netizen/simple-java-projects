package com.librarymanagement.service;

import com.librarymanagement.repository.MemberRepository;
import com.librarymanagement.model.Member;

public class MemberService {
    private MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    Validator validator = new Validator();

    public ServiceResult addMember(String memberType,String name,String email) throws InvalidBookException {
        validator.validate(memberType,"MemberType");
        validator.validate(name,"Name");
        validator.validate(email,"Email");

        String memberId = generateMemberId(memberType);
        Member member = new Member(memberId,name,email);
        memberRepository.addMember(member);
        return new ServiceResult(true, "Member added successfully!");
    }



    int memberCounter = 1;
    private String generateMemberId(String memberType){
        memberType = memberType.toLowerCase();

        switch(memberType){
            case "student" :
                return String.format("STU03%d",memberCounter++);
            case "faculty" :
                return String.format("FAC03%d",memberCounter++);
            default :
                return String.format("MEM03%d",memberCounter++);
        }

    }
}
