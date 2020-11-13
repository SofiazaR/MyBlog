package ru.itis.models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;
import java.util.List;
@Builder
@EqualsAndHashCode
@Getter
@ToString
public class Post {
    private String post;
    private Date data;
    private String userName;
    private String category;
    private List<Tag> tagsList;

}
