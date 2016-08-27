package com.cms.repository;

import com.cms.model.Goal;
import com.cms.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IGoalDAO extends JpaRepository<Goal, Integer>,
        JpaSpecificationExecutor<Goal> {

	/*
     * @Query("SELECT u FROM Role u WHERE LOWER(u.Rolename) = LOWER(:name)")
	 * Role retrieveByName(@Param("name") String name);
	 */
}
