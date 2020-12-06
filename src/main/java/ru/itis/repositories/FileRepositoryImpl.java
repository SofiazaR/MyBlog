package ru.itis.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import ru.itis.models.FileInfo;

import javax.sql.DataSource;
import java.util.*;

public class FileRepositoryImpl implements FileRepository {

    //language=SQL
    private final static String SQL_INSERT = "insert into file(storage_name, original_name, type, size) " +
            "values (?, ?, ?, ?)";
    private final static String SQL_SELECT_BY_ID = "select * from file where id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SimpleJdbcInsert simpleJdbcInsert;

    public FileRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }



    private final RowMapper<FileInfo> fileRowMapper = (row, rowNumber) ->
            FileInfo.builder()
                    .id(row.getLong("id"))
                    .originalName(row.getString("original_name"))
                    .storageName((UUID) row.getObject("storage_name"))
                    .size(row.getLong("size"))
                    .type(row.getString("type"))
                    .build();


    @Override
    public void save(FileInfo entity) {
        Long fileId = saveFileInfo(entity);
        entity.setId(fileId);
    }

    private Long saveFileInfo(FileInfo fileInfo) {
        simpleJdbcInsert.withTableName("file").usingGeneratedKeyColumns("id")
                .usingColumns("storage_name", "original_name", "type", "size");
        Map<String, Object> map = new HashMap<>();
        map.put("storage_name", fileInfo.getStorageName());
        map.put("original_name", fileInfo.getOriginalName());
        map.put("type", fileInfo.getType());
        map.put("size", fileInfo.getSize());
        return Long.parseLong(simpleJdbcInsert.executeAndReturnKey(map).toString());
    }

    @Override
    public void update(FileInfo entity) {
        
    }

    @Override
    public void delete(FileInfo entity) {

    }

    @Override
    public Optional<FileInfo> findById(Long id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, fileRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public ArrayList<FileInfo> findAll() {
        return null;
    }


}