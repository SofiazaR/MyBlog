package ru.itis.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.itis.models.Post;
import ru.itis.models.Tag;

import javax.sql.DataSource;
import java.util.*;

@Repository
public class PostRepositoryJdbcTemplateImpl implements PostRepository {
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    public void PostRepositorySimpleJdbcInsert(DataSource dataSource) {
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("post")
                .usingGeneratedKeyColumns("id")
                .usingColumns("text", "name", "user_id", "category", "file_id");

    }

    public PostRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final String SQL_SELECT_ALL_FROM_POST_BY_USER = "select distinct post.id,post.name,data,text,\"user\".name t,category,file_id from post\n" +
            "join \"user\" on post.user_id = \"user\".id\n" +
            "join post_and_tag pat on post.id = pat.post_id\n" +
            "where \"user\".name = ? order by post.id";

    private static final String SQL_SELECT_ALL_FROM_POST = "select distinct post.id,post.name,data,text,\"user\".name t,category,file_id from post\n" +
            "join \"user\" on post.user_id = \"user\".id\n" +
            "join post_and_tag pat on post.id = pat.post_id\n" +
            "order by post.id";
    //language=sql
    private static final String SQL_SELECT_ALL_FROM_TAG = "select id, tag from post_and_tag\n" +
            "join tag t on t.id = post_and_tag.tag_id";


    private final RowMapper<Post> postRowMapper = (row, rowNumber) -> Post.builder()
            .id(row.getLong("id"))
            .name(row.getString("name"))
            .text(row.getString("text"))
            .data(row.getDate("data"))
            .userName(row.getString("t"))
            .category(row.getString("category"))
            .fileId(row.getLong("file_id"))
            .build();

    private final RowMapper<Tag> tagsRowMapper = (row, rowNumber) -> Tag.builder()
            .postId(row.getLong("id"))
            .tag(row.getString("tag"))
            .build();


    @Override
    public void save(Post entity) {
        Long fileId = savePost(entity);
        entity.setId(fileId);
    }

    private Long savePost(Post post) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", post.getName());
        map.put("text", post.getText());
        map.put("user_id", post.getUserId());
        map.put("category", post.getCategory());
        map.put("file_id", post.getFileId());
        return Long.parseLong(simpleJdbcInsert.executeAndReturnKey(map).toString());
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
        List<Tag> tags = jdbcTemplate.query(SQL_SELECT_ALL_FROM_TAG, tagsRowMapper);

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
    public List<Post> findAllByUser(String user) {
        List<Tag> tags = jdbcTemplate.query(SQL_SELECT_ALL_FROM_TAG, tagsRowMapper);

        Map<Long, ArrayList<String>> postTags = new HashMap<>();

        for (Tag row : tags) {
            ArrayList<String> list = postTags.get(row.getPostId());
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(row.getTag());
            postTags.put(row.getPostId(), list);
        }

        ArrayList<Post> posts = (ArrayList<Post>) jdbcTemplate.query(SQL_SELECT_ALL_FROM_POST_BY_USER, postRowMapper, user);
        for (Post post : posts) {
            post.setTagsList(postTags.get(post.getId()));
        }
        return posts;
    }
}
