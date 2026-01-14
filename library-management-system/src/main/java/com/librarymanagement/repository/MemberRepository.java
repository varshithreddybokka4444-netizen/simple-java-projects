package com.librarymanagement.repository;

import com.librarymanagement.model.Member;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MemberRepository {
private final Map<String, Member> members = new HashMap<>();
public void addMember(Member member){
    members.put(member.getMemberId(),member);
}
public Member fingMemberById(String memberId){
    return members.get(memberId);
}
public Collection<Member> getAll(){
    return Collections.unmodifiableCollection(members.values());
    }
}
