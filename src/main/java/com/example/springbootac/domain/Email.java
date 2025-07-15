package com.example.springbootac.domain;

import java.util.regex.Pattern;

public record Email(String address) {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
    // record 는 생성자에서 파라미터로 받은 값 그대로 사용 가능
    public Email {

        if (!EMAIL_PATTERN.matcher(address).matches()) {
            throw new IllegalArgumentException("invalid email format: " + address);
        }
    }
}
