package ru.itis.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
@Data
@Builder
@EqualsAndHashCode
@ToString
public class Post {
    private Long id;
    private String name;
    private String text;
    private Date data;
    private String userName;
    private String category;
    private ArrayList<String> tagsList;
    private Long userId;
    private Long fileId;
}
