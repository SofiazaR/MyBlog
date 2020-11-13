package ru.itis.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import ru.itis.models.Post;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostRepositoryJdbcTemplateImpl implements PostRepository {
    private JdbcTemplate jdbcTemplate;
    public PostRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Post entity) {


    }

    @Override
    public void update(Post entity) {

    }

    @Override
    public void delete(Post entity) {

    }

    @Override
    public Optional<Post> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public ArrayList<Post> findAll() {
        return null;
    }

    @Override
    public List<Post> findAllByTag(String tag) {
        return null;
    }
}
