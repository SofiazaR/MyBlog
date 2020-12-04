package ru.itis.models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Builder
@EqualsAndHashCode
@ToString
public class Video {
    private String resume;
    private String link;
}
