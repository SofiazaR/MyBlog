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
    private String postText;
    private Date data;
    private String userName;
    private String category;
    private List<String> tagsList;
    private String file_name;
    private String type;

    public static PostDto from(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .userName(post.getUserName())
                .postText(post.getPostText())
                .file_name(post.getFileName())
                .data(post.getData())
                .category(post.getCategory())
                .tagsList(post.getTagsList())
                .type(post.getType().substring(post.getType().indexOf("/")+1))
                .build();
    }

    public static List<PostDto> from(List<Post> cars) {
        return cars.stream().map(PostDto::from).collect(Collectors.toList());
    }
}
