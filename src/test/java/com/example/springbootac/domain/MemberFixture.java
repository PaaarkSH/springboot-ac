package com.example.springbootac.domain;

public class MemberFixture {


    public static MemberRegisterRequest createMemberRegisterRequest(String mail) {
        return new MemberRegisterRequest(mail, "nick", "secret");
    }

    public static MemberRegisterRequest createMemberRegisterRequest() {
        return new MemberRegisterRequest("test@test.com", "nick", "secret");
    }

    public static PasswordEncoder createPasswordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(String password) {
                return password.toUpperCase();
            }

            @Override
            public boolean matches(String password, String encodedPassword) {
                return encode(password).equals(encodedPassword);
            }
        };
    }

}
