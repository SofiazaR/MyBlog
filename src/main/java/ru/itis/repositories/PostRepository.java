package ru.itis.repositories;

import ru.itis.models.Post;

import java.util.List;

public interface PostRepository extends CrudRepository<Post>{

    List<Post> findAllByUser(String user);
}
