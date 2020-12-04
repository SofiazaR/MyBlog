package ru.itis.services;

import ru.itis.dto.PostDto;

import java.util.ArrayList;

public interface VideosService{
    Long saveVideo(String resume,String link);
    ArrayList<VideoDto> findAll();
}
