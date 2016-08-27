package com.cms.service;

import com.cms.api.IUserApi;
import com.cms.dto.UserDTO;
import com.cms.model.User;
import com.cms.utility.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by amit on 6/19/16.
 */

@Service
public class UserService implements IUserService {

    @Autowired
    IUserApi userApi;


    public String createOrEditApplicationUser(UserDTO dto) {
        User user = userApi.createOrEditAppUser(dto);
        if (user != null) {
            return String.valueOf(user.getId());
        }
        return "Error in creating user";
    }


    public List<UserDTO> getAllUsers() {


        return ConvertUtils.convertToUserDTOs(userApi.getAllUsers());
    }

    @Override
    public String deleteUser(Integer id) {
        return userApi.deleteUser(id);
    }

    @Override
    public UserDTO getUser(Integer id) {
        return ConvertUtils.convertToUserDTO(userApi.getUserById(id));
    }


}
