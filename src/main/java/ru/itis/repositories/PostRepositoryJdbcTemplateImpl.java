package ru.itis.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Post;
import ru.itis.models.Tag;

import javax.sql.DataSource;
import java.util.*;

public class PostRepositoryJdbcTemplateImpl implements PostRepository {
    private JdbcTemplate jdbcTemplate;

    public PostRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //language=sql
    private static final String SQL_SELECT_ALL_FROM_POST = "select distinct post.id,data,post_text,user_name,category, storage_file_name,f.type from post\n" +
            "join \"user\" on post.user_id = \"user\".id\n" +
            "join file f on post.file_id = f.id\n" +
            "join post_and_tag pat on post.id = pat.post_id\n";
    //language=sql
    private static final String SQL_SELECT_ALL_FROM_TAG = "select post_id, tag from post_and_tag\n" +
            "join tag t on t.id = post_and_tag.tag_id";

    private final RowMapper<Post> postRowMapper = (row, rowNumber) -> Post.builder()
            .id(row.getLong("id"))
            .postText(row.getString("post_text"))
            .data(row.getDate("data"))
            .userName(row.getString("user_name"))
            .category(row.getString("category"))
            .fileName(row.getString("storage_file_name"))
            .type(row.getString("type"))
            .build();

    private final RowMapper<Tag> tagRowMapper = (row, rowNumber) -> Tag.builder()
            .postId(row.getLong("post_id"))
            .tag(row.getString("tag"))
            .build();


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
        List<Tag> tags = jdbcTemplate.query(SQL_SELECT_ALL_FROM_TAG, tagRowMapper);

        Map<Long, ArrayList<String>> postTags = new HashMap<>();

        for (Tag row : tags) {
            ArrayList<String> list = postTags.get(row.getPostId());
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(row.getTag());
            postTags.put(row.getPostId(), list);
        }

        ArrayList<Post> posts = (ArrayList<Post>) jdbcTemplate.query(SQL_SELECT_ALL_FROM_POST, postRowMapper);
        for (Post post : posts) {
            post.setTagsList(postTags.get(post.getId()));
        }
        return posts;
    }

    @Override
    public List<Post> findAllByTag(String tag) {
        return null;
    }
}
