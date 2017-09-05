package io.github.neferupito.hederahotel.service;

import io.github.neferupito.hederahotel.model.user.User;

public interface UserService {

    User findUserByLogin(String login);
    User saveUser(User user);

}