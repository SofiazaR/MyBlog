package ru.itis.services;

import ru.itis.dto.VideoDto;

import java.util.ArrayList;

public interface VideosService{
    void saveVideo(String resume,String link);
    ArrayList<VideoDto> findAllVideos();

}
