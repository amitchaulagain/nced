package com.cms.repository;

import com.cms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUserDAO extends JpaRepository<User, Integer>,
        JpaSpecificationExecutor<User> {

    @Query("SELECT u FROM User u WHERE LOWER(u.username) = LOWER(:name)")
    User retrieveByName(@Param("name") final String name);

}
