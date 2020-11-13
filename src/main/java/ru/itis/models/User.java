package ru.itis.models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@EqualsAndHashCode
@Getter
@ToString

public class User {
    private Long id;
    private String email;
    private String userName;
    private String hashPassword;
    private Integer age;
}
