package com.insdrums.imagine_api.service;

import com.insdrums.imagine_api.dto.SaveUser;
import com.insdrums.imagine_api.model.entity.User;

import java.util.Optional;

public interface UserService {
    User registerOneUser(SaveUser newUser);
    Optional<User> findOneByEmail(String email);
}
