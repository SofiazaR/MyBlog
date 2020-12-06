package ru.itis.services;

import ru.itis.models.Tag;
import ru.itis.repositories.TagRepository;

import java.util.ArrayList;
import java.util.List;

public class TagServiceImpl implements TagService {
    private TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public void saveTag(Long postId, String tagName) {

        String[] subStr;
        subStr = tagName.split("#");
        for (String s : subStr) {
            Tag tag = Tag.builder().tag(s.trim()).build();
            tagRepository.save(tag);
            tagRepository.bindTagWithPost(tag.getId(), postId);
        }


    }


}
