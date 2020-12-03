package ru.itis.models;

import lombok.*;

@Builder
@EqualsAndHashCode
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String email;
    private String userName;
    private String hashPassword;
    private Integer age;
}
