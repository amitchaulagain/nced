package com.cms.repository;

import com.cms.model.TrainingCenter;
import com.sun.jndi.toolkit.ctx.Continuation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITrainingCenterDAO extends JpaRepository<TrainingCenter, Integer>,
        JpaSpecificationExecutor<TrainingCenter> {
    TrainingCenter findTrainingCenterByName(String parentTrainingCenter);


    @Query("SELECT u  FROM TrainingCenter u WHERE u.parentTrainingCenter.name =  :tcName")
    TrainingCenter retrieveByName(@Param("tcName") String tcName);

    @Query("SELECT u  FROM TrainingCenter u WHERE u.parentTrainingCenter.id = NULL")
    List<TrainingCenter> findAllParentTrainingCenter();


    @Query("SELECT count(u)   FROM TrainingCenter u WHERE u.parentTrainingCenter.id = :id")
    Integer countChildTrainingCenter(@Param("id") Integer id);
}
