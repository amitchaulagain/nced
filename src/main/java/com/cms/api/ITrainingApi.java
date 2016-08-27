package com.cms.api;

import com.cms.dto.MemberDTO;
import com.cms.dto.TrainingCenterDTO;
import com.cms.dto.TrainingDTO;
import com.cms.model.Training;

import java.util.List;

/**
 * Created by amit on 6/16/16.
 */
public interface ITrainingApi {
    String createOrEditTrainingCenter(TrainingCenterDTO tc);

    TrainingCenterDTO findTrainingCenterById(Integer id);

    String deleteTrainingCenter(Integer id);

    List<TrainingCenterDTO> findAllTrainingCenter();

    List<TrainingCenterDTO> findAllParentTrainingCenter();

    List<TrainingDTO> findTrainingsConductedByTrainingCenterId(Integer id);

    String createOrEditTraining(TrainingDTO dto);

    TrainingDTO getSingleTraining(Integer id);

    String createOrEditMember(MemberDTO dto);

    List<MemberDTO> findMembersByTrainingId(Integer trainingId);

    MemberDTO getSingleMember(Integer id);

    String deleteMember(Integer id);

    String deleteTraining(Integer trainingId);

    List<Training> getTrainingByFiscalYear(String fiscalYear);

    int countNumberOfAttendeesInTraining(int id);

    int countNumberOfMale(int id);

    String countChildTrainingCenter(Integer id);
}
