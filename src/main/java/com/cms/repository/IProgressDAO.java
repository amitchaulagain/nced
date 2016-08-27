package com.cms.repository;

import com.cms.model.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IProgressDAO extends JpaRepository<Progress, Integer>,
        JpaSpecificationExecutor<Progress> {





	/*
     * @Query("SELECT u FROM Role u WHERE LOWER(u.Rolename) = LOWER(:name)")
	 * Role retrieveByName(@Param("name") String name);
	 */
}
