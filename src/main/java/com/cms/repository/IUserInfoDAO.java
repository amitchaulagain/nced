package com.cms.repository;

import com.cms.model.User;
import com.cms.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUserInfoDAO extends JpaRepository<UserInfo, Integer>,
        JpaSpecificationExecutor<User> {

   /* @Query("SELECT u FROM User u WHERE LOWER(u.username) = LOWER(:name)")
    User retrieveByName(@Param("name") final String name);*/

    @Query("SELECT ui FROM UserInfo ui WHERE ui.user.id=:userId")
    UserInfo getUserInfoByUserId(@Param("userId") Integer userId);

}
