package com.librarymanagement.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MemberTest {
    @Test
    void shouldCreateMemberWithCorrectIdentity(){
    Member member = new Member("Member-001",
            "Varshith",
            "varshith.bokka01@gmail.com"
    );

    assertEquals("Varshith",member.getName());
    assertEquals("Member-001",member.getMemberId());
    assertEquals("varshith.bokka01@gmail.com",member.getEmail());
}
    @Test
    void shouldAllowUpdatingContactDetails(){
        Member member = new Member("Member-001",
                "Varshith",
                "varshith.bokka01@gmail.com"
        );

        member.setName("Varshith Reddy Bokka");
        member.setEmail("varshithreddybokka4444@gmail.com");

        assertEquals("Varshith Reddy Bokka",member.getName());
        assertEquals("varshithreddybokka4444@gmail.com",member.getEmail());

    }

    @Test
    void memberIdShouldRemainUnchanged(){
        Member member = new Member("Member-001",
                "Varshith",
                "varshith.bokka01@gmail.com"
        );

        assertEquals("Member-001",member.getMemberId());
    }

}