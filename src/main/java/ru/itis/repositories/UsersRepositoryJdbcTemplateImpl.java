package ru.itis.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.User;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {
    private JdbcTemplate jdbcTemplate;
    //language=sql
    private static final String SQL_INSERT = "INSERT INTO \"user\" (user_name, age, email, hash_password) values (?,?,?,?)";
    private static final String SQL_SELECT_BY_EMAIL = "Select * from \"user\" where email=?";

    private final RowMapper<User> userRowMapper = (row, rowNumber) -> User.builder()
            .id(row.getLong("id"))
            .userName(row.getString("user_name"))
            .email(row.getString("email"))
            .hashPassword(row.getString("hash_password"))
            .age(row.getInt("age"))
            .build();

    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_EMAIL, userRowMapper, email));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void updatePassword(Long id, String hashPassword) {

    }

    @Override
    public void save(User entity) {
        jdbcTemplate.update(SQL_INSERT,

                entity.getUserName(),
                entity.getAge(),
                entity.getEmail(),
                entity.getHashPassword());

    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public ArrayList<User> findAll() {
        return null;
    }
}
