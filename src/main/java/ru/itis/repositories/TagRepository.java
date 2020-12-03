package ru.itis.repositories;

import ru.itis.models.Tag;

public interface TagRepository extends CrudRepository<Tag> {
    void bindTagWithPost(Long tagId, Long postId);

}
