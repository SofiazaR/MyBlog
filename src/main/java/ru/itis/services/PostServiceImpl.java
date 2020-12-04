package ru.itis.services;

import ru.itis.dto.PostDto;
import ru.itis.models.Post;
import ru.itis.models.User;
import ru.itis.repositories.PostRepository;

import java.util.ArrayList;

public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Long savePost(String text,String name,Long userId, String category, Long fileId) {
        Post post = Post.builder()
                .text(text)
                .name(name)
                .userId(userId)
                .category(category)
                .fileId(fileId)
                .build();

        postRepository.save(post);
        return post.getId();

    }




    @Override
    public ArrayList<PostDto> findAll() {
        return (ArrayList<PostDto>) PostDto.from(postRepository.findAll());
    }

    @Override
    public ArrayList<PostDto> findAllByUser(User user) {
            return (ArrayList<PostDto>) PostDto.from(postRepository.findAllByUser(user.getUserName()));
    }
}
