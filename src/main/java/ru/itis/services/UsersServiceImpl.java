package ru.itis.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.dto.ChangePasswordForm;
import ru.itis.dto.UserDto;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UsersServiceImpl implements UsersService {
    private UsersRepository usersRepository;
    private PasswordEncoder passwordEncoder;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public List<UserDto> getAllUsers() {
        return UserDto.from(usersRepository.findAll());
    }

    @Override
    public void saveUser(Map<String, String> pool) {
        User user = User.builder()
                .userName(pool.get("name"))
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

    @Override
    public Boolean changePassword(ChangePasswordForm changePasswordForm) {
        Optional<User> user = usersRepository.findById(changePasswordForm.getUserId());

        if (changePasswordForm.getNewPassword().equals(changePasswordForm.getRepeatedNewPassword())) {

            if (user.isPresent() &&
                    passwordEncoder.matches(changePasswordForm.getOldPassword(), user.get().getHashPassword())) {

                usersRepository.updatePassword(user.get().getId(), passwordEncoder.encode(changePasswordForm.getNewPassword()));
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

}
