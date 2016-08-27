package com.cms.api;

import com.cms.dto.UserDTO;
import com.cms.model.User;

import java.util.List;

/**
 * Created by amit on 6/19/16.
 */
public interface IUserApi {
    User createOrEditAppUser(UserDTO dto);
    List<User> getAllUsers();

    String deleteUser(Integer id);

    User getUserById(Integer id);
}
