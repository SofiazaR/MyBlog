package ru.itis.services;

import ru.itis.models.Post;
import ru.itis.repositories.PostRepository;

import java.util.ArrayList;

public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public ArrayList<Post> findAll() {
        return postRepository.findAll();
    }
}
