package com.cms.repository;

import com.cms.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProjectDAO extends JpaRepository<Project, Integer>,
        JpaSpecificationExecutor<Project> {

    @Query("SELECT p FROM Project p WHERE p.fiscalYear =:fiscalYear")
    List<Project> findProjectsByFiscalYear(@Param("fiscalYear") String fiscalYear);

    @Query("SELECT p FROM Project p WHERE p.projectCode =:code")
    Project findProjectByProjectCode(@Param("code") String code);
}
