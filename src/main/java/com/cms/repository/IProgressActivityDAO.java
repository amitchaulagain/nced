package com.cms.repository;

import com.cms.dto.ProgressDTO;
import com.cms.model.ActivityProgress;
import com.cms.model.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProgressActivityDAO extends JpaRepository<ActivityProgress, Integer>,
        JpaSpecificationExecutor<ActivityProgress> {


    @Query("SELECT u FROM ActivityProgress u WHERE u.progress.id=:id")
    ActivityProgress findActivityProgressByProgressId(@Param("id") Integer id);


    @Query("SELECT u.progress FROM ActivityProgress u WHERE u.activity.id=:id")
    List<Progress> findProgressByActivityId(@Param("id") Integer id);

    @Query("SELECT u FROM ActivityProgress u WHERE u.activity.id=:id")
    List<ActivityProgress> findProgressActivityByActivityId(@Param("id") Integer id);

    @Query("SELECT u FROM ActivityProgress u WHERE u.activity.project.fiscalYear=:fiscalYear")
    List<ActivityProgress> findAllProgressSubmittedInFiscalYear(@Param("fiscalYear") String fiscalYear);


//    @Query("DELETE FROM ActivityProgress u where u.progress.id=:id")
//    void deleteProgressByProgressId(@Param("id") Integer id);





	/*
     * @Query("SELECT u FROM Role u WHERE LOWER(u.Rolename) = LOWER(:name)")
	 * Role retrieveByName(@Param("name") String name);
	 */
}
