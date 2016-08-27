package com.cms.repository;

import com.cms.model.Role;
import com.cms.model.Training;
import com.cms.model.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITrainingDAO extends JpaRepository<Training, Integer>,
        JpaSpecificationExecutor<Training> {


    @Query("SELECT t FROM Training t WHERE t.trainingCenter.id=:id")
    List<Training> findTrainingByTrainingCenterId(@Param("id") Integer id);

    @Query("SELECT t FROM Training t WHERE t.fiscalYear=:fiscalYear")
    List<Training> findTrainingsByFiscalYear(@Param("fiscalYear")String fiscalYear);
}
