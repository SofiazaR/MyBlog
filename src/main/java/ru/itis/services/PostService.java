package ru.itis.services;

import ru.itis.dto.PostDto;
import ru.itis.models.User;

import java.util.ArrayList;

public interface PostService {
    Long savePost(String text,String name,Long userId, String category, Long fileId);
    ArrayList<PostDto> findAll();
    ArrayList<PostDto> findAllByUser(User user);
}
