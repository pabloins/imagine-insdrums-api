package com.insdrums.imagine_api.service.impl;

import com.insdrums.imagine_api.dto.SaveUser;
import com.insdrums.imagine_api.model.entity.Role;
import com.insdrums.imagine_api.model.entity.User;
import com.insdrums.imagine_api.repository.UserRepository;
import com.insdrums.imagine_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //Aca puedes crear metodos separados para crear usuarios dependiendo del rol, acordarse de hacer el controller por cada metodo
    @Override
    public User registerOneUser(SaveUser newUser) {

        validatePassword(newUser);

        User user = new User();
        user.setName(newUser.getName());
        user.setEmail(newUser.getEmail());
        user.setUsername(newUser.getUsername());
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));
        user.setRole(Role.ROLE_SERNAPRED);

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findOneByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void validatePassword(SaveUser dtoUser) {
        if(!StringUtils.hasText(dtoUser.getPassword()) || !StringUtils.hasText(dtoUser.getRepeatedPassword())) {
            throw new RuntimeException("Passwords don`t match");
        }

        if(!dtoUser.getPassword().equals(dtoUser.getRepeatedPassword())) {
            throw new RuntimeException("Passwords don`t match");
        }
    }
}
