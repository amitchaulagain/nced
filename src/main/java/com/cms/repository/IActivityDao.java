package com.cms.repository;

import com.cms.model.Activity;
import com.cms.model.Goal;
import com.cms.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IActivityDao extends JpaRepository<Activity, Integer>,
        JpaSpecificationExecutor<Activity> {


    @Query("SELECT u FROM Activity u WHERE u.project.id =:projectId")
    List<Activity> findActivitiesByProjectId(@Param("projectId") Integer projectId);

    @Query("SELECT u FROM Activity u WHERE u.project.fiscalYear =:fiscalYear")
    List<Activity> findActivitiesByFiscalYear(@Param("fiscalYear") String fiscalYear);

	/*
     * @Query("SELECT u FROM Role u WHERE LOWER(u.Rolename) = LOWER(:name)")
	 * Role retrieveByName(@Param("name") String name);
	 */
}
