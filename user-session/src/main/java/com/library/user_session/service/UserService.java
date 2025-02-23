package com.library.user_session.service;

import com.library.user_session.model.User;
import com.library.user_session.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        var userExists = userRepository.existByUsernameOrMail(user.getUsername(), user.getMail());

        if (userExists) {
            throw new RuntimeException("Username or Mail already in use, try again please!");
        }

        var savedUser = userRepository.save(user);
        savedUser.setId(null);

        return savedUser;
    }

    public String login() {
    return "";
    }


}
