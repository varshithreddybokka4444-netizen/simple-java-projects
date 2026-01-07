package com.librarymanagement.model;

public class Member {
    private final int memberId;
    private String name;
    private String email;
    private boolean active = true;

    public Member(int memberId, String name, String email) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
    }
    public int getMemberId() {
        return memberId;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public boolean isActive() {
        return active;
    }
    public void setIsActive(boolean isActive) {
        this.active = isActive;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
