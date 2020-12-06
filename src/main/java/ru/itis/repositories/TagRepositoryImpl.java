package ru.itis.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import ru.itis.models.Tag;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TagRepositoryImpl implements TagRepository {

    //language=sql
    private static final String SQL_LOOK_TAG = "select * from tag where tag=?";
    //language=sql
    private static final String SQL_INSERT_POST_AND_TAG = "insert into post_and_tag values(?,?)";

    private JdbcTemplate jdbcTemplate;
@Autowired
    private SimpleJdbcInsert simpleJdbcInsert;

    public TagRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);

    }

    private final RowMapper<Tag> tagRowMapper = (row, rowNumber) -> Tag.builder()
            .id(row.getLong("id"))
            .tag(row.getString("tag"))
            .build();

    @Override
    public void save(Tag tag) {
        try {
            Tag dbTag = jdbcTemplate.queryForObject(SQL_LOOK_TAG, tagRowMapper, tag.getTag());
            tag.setId(dbTag.getId());
        } catch (EmptyResultDataAccessException e) {
            Long tagId = saveTag(tag);
            tag.setId(tagId);
        }

    }

    private Long saveTag(Tag tag) {
        simpleJdbcInsert.withTableName("tag").usingGeneratedKeyColumns("id")
                .usingColumns("tag");
        Map<String, Object> map = new HashMap<>();
        map.put("tag", tag.getTag());
        return Long.parseLong(simpleJdbcInsert.executeAndReturnKey(map).toString());
    }

    @Override
    public void update(Tag entity) {

    }

    @Override
    public void delete(Tag entity) {

    }

    @Override
    public Optional<Tag> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public ArrayList<Tag> findAll() {
        return null;
    }

    @Override
    public void bindTagWithPost(Long tagId, Long postId) {
        jdbcTemplate.update(SQL_INSERT_POST_AND_TAG, postId, tagId);
    }
}
