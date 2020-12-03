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
        List<Tag> tags = new ArrayList<>();

        String[] subStr;
        subStr = tagName.split("#");
        for (int i = 0; i < subStr.length; i++) {
            Tag tag = Tag.builder().tag(tagName.trim()).build();
            tagRepository.save(tag);
            tagRepository.bindTagWithPost(tag.getId(), postId);
            tags.add(tag);
        }


    }


}
