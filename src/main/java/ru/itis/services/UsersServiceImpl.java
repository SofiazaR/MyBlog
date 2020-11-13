package ru.itis.services;

import ru.itis.dto.UserDto;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UsersServiceImpl implements UsersService {
    private UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return UserDto.from(usersRepository.findAll());
    }

    @Override
    public void saveUser(Map<String, String> pool) {
        User user = User.builder()
                .userName(pool.get("user_name"))
                .hashPassword(pool.get("hash_password"))
                .email(pool.get("email"))
                .age(Integer.parseInt(pool.get("age")))
                .build();
        usersRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

}
