package ru.itis.models;

import lombok.*;

@Builder
@EqualsAndHashCode
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Tag {

    private Long postId;
    private String tag;
    private Long id;
}
