package ru.itis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.models.Post;
import ru.itis.models.Tag;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private Long id;
    private String name;
    private String text;
    private Date data;
    private String userName;
    private String category;
    private List<String> tagsList;
    private Long fileId;

    public static PostDto from(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .userName(post.getUserName())
                .name(post.getName())
                .text(post.getText())
                .data(post.getData())
                .category(post.getCategory())
                .tagsList(post.getTagsList())
                .fileId(post.getFileId())
                .build();
    }

    public static List<PostDto> from(List<Post> posts) {
        return posts.stream().map(PostDto::from).collect(Collectors.toList());
    }
}
