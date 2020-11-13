package ru.itis.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.dto.UserForm;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;

public class SignUpServiceImpl implements SignUpService {

    private UsersRepository usersRepository;
    private PasswordEncoder passwordEncoder;

    public SignUpServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public void signUp(UserForm userForm) {
        User user = User.builder()
                .userName(userForm.getUserName())
                .email(userForm.getEmail())
                .hashPassword(passwordEncoder.encode(userForm.getPassword()))
                .age(userForm.getAge())
                .build();
        usersRepository.save(user);
    }
}
