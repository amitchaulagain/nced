package com.cms.repository;

import com.cms.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRoleDAO extends JpaRepository<Role, Integer>,
        JpaSpecificationExecutor<Role> {




    @Query("SELECT r FROM Role r WHERE r.user.id=:userid AND r.role=:rr ")
    Role findRoleByUserIdAndValue(@Param("rr") String role,@Param("userid") int userid);


    @Query("SELECT r FROM Role r WHERE r.user.id=:userid")
    List<Role> findRolesByUserId(@Param("userid") int userid);

	/*
     * @Query("SELECT u FROM Role u WHERE LOWER(u.Rolename) = LOWER(:name)")
	 * Role retrieveByName(@Param("name") String name);
	 */
}
