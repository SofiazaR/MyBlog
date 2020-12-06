package ru.itis.services;

import ru.itis.dto.VideoDto;
import ru.itis.models.Video;
import ru.itis.repositories.VideosRepository;

import java.util.ArrayList;


public class VideosServiceImpl implements VideosService {
    private VideosRepository videosRepository;

    public VideosServiceImpl(VideosRepository videosRepository){
        this.videosRepository = videosRepository;
    }

    @Override
    public void saveVideo(String resume, String link) {
        Video video = Video.builder()
                .resume(resume)
                .link(link)
                .build();

        videosRepository.save(video);
    }

    @Override
    public ArrayList<VideoDto> findAllVideos() {
        return (ArrayList<VideoDto>) VideoDto.from(videosRepository.findAll());
    }
}
