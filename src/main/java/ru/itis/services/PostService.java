package ru.itis.services;

import ru.itis.models.Post;

import java.util.ArrayList;

public interface PostService {
    ArrayList<Post> findAll();
}
