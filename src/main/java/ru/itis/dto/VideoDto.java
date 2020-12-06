package ru.itis.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import ru.itis.models.Video;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@EqualsAndHashCode
@ToString
@Getter
public class VideoDto {
    private Long id;
    private String resume;
    private String link;


    public static VideoDto from(Video video) {
        return VideoDto.builder()
                .id(video.getId())
                .resume(video.getResume())
                .link(video.getLink())
                .build();
    }

    public static List<VideoDto> from(List<Video> videos) {
        return videos.stream().map(VideoDto::from).collect(Collectors.toList());
    }
}
