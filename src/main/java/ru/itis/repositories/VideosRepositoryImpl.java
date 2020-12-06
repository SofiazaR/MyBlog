package ru.itis.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import ru.itis.models.Post;
import ru.itis.models.Video;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Optional;

public class VideosRepositoryImpl implements VideosRepository {
    private JdbcTemplate jdbcTemplate;

    //language=sql
    private static final String SQL_SELECT_ALL = "select id, resume, link from videos";
    private static final String SQL_INSERT = "INSERT INTO videos (resume,link) values (?,?)";

    public VideosRepositoryImpl(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final RowMapper<Video> videoRowMapper = (row, rowNumber) -> Video.builder()
            .id(row.getLong("id"))
            .resume(row.getString("resume"))
            .link(row.getString("link"))
            .build();

    @Override
    public void save(Video entity) {
        jdbcTemplate.update(SQL_INSERT,
                entity.getResume(),
                entity.getLink());
    }

    @Override
    public void update(Video entity) {

    }

    @Override
    public void delete(Video entity) {

    }

    @Override
    public Optional<Video> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public ArrayList<Video> findAll() {
       return (ArrayList<Video>) jdbcTemplate.query(SQL_SELECT_ALL, videoRowMapper);
    }
}
