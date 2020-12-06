package ru.itis.models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


@Builder
@EqualsAndHashCode
@ToString
@Getter
public class Video {
    private Long id;
    private String resume;
    private String link;
}
