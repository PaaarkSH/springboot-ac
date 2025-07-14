package com.example.springbootac.domain;

public record MemberCreateRequest(String email, String nickname, String password) {
}
