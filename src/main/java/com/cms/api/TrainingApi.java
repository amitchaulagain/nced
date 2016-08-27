package com.cms.api;

import com.cms.dto.MemberDTO;
import com.cms.dto.TrainingCenterDTO;
import com.cms.dto.TrainingDTO;
import com.cms.model.Member;
import com.cms.model.Training;
import com.cms.model.TrainingCenter;
import com.cms.repository.IMemberDAO;
import com.cms.repository.ITrainingCenterDAO;
import com.cms.repository.ITrainingDAO;
import com.cms.utility.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by amit on 6/16/16.
 */
@Service
public class TrainingApi implements ITrainingApi {


    @Autowired
    ITrainingCenterDAO trainingCenterDAO;
    @Autowired
    ITrainingDAO trainingDAO;
    @Autowired
    IMemberDAO memberDAO;

    @Override
    public String createOrEditTrainingCenter(TrainingCenterDTO dto) {
        TrainingCenter tc = trainingCenterDAO.findOne(dto.getId());
        if (tc == null) {
            tc = new TrainingCenter();
        }
        tc.setAddress(dto.getAddress());
        tc.setDistrict(dto.getDistrict());
        tc.setName(dto.getName());
        tc.setZone(dto.getZone());
        if (dto.getParentTrainingCenter() != null) {
            TrainingCenter parent = trainingCenterDAO.findTrainingCenterByName(dto.getParentTrainingCenter());
            tc.setParentTrainingCenter(parent);
        }
        trainingCenterDAO.save(tc);
        return tc.getId().toString();
    }

    @Override
    public TrainingCenterDTO findTrainingCenterById(Integer id) {
        return ConvertUtils.convertToTrainingCenterDTO(trainingCenterDAO.findOne(id));
    }

    @Override
    public String deleteTrainingCenter(Integer id) {
        trainingCenterDAO.delete(id);
        return id.toString();
    }

    @Override
    public List<TrainingCenterDTO> findAllTrainingCenter() {
        return ConvertUtils.convertToTrainingCenterDTOs(trainingCenterDAO.findAll());
    }

    @Override
    public List<TrainingCenterDTO> findAllParentTrainingCenter() {
        return ConvertUtils.convertToTrainingCenterDTOs(trainingCenterDAO.findAllParentTrainingCenter());
    }

    @Override
    public List<TrainingDTO> findTrainingsConductedByTrainingCenterId(Integer id) {
        return ConvertUtils.convertToTrainingDTOs(trainingDAO.findTrainingByTrainingCenterId(id));
    }

    @Override
    public String createOrEditTraining(TrainingDTO dto) {
        Training training = trainingDAO.findOne(dto.getId());
        if (training == null) {
            training = new Training();
        }

        training.setName(dto.getName());
        training.setBudget(dto.getBudget());
        training.setStartDate(dto.getStart());
        training.setEndDate(dto.getEnd());
        training.setTarget(dto.getTarget());
        training.setTrainingCenter(trainingCenterDAO.findOne(dto.getTrainingCenterId()));

        trainingDAO.save(training);
        return training.getId().toString();
    }

    @Override
    public TrainingDTO getSingleTraining(Integer id) {
        return ConvertUtils.convertToTrainingDTO(trainingDAO.findOne(id));
    }

    @Override
    public String createOrEditMember(MemberDTO dto) {
        Member member = memberDAO.findOne(dto.getMemberId());
        if (member == null) {
            member = new Member();
        }

        member.setFirstName(dto.getFirstName());
        member.setMiddleName(dto.getMiddleName());
        member.setLastName(dto.getLastName());
        member.setDistrict(dto.getDistrict());
        member.setStreetAddress(dto.getStreetAddress());
        member.setZone(dto.getZone());
        member.setVdcOrMunicipality(dto.getVdcOrMunicipality());
        member.setCountry(dto.getCountry());
        member.setDob(dto.getDob());
        member.setEmail(dto.getEmail());
        member.setMale(dto.isMale());
        member.setMemberType(dto.getMemberType());
        member.setLandlineNumber(dto.getLandlineNumber());
        member.setMobileNumber(dto.getMobileNumber());
        member.setOrganisation(dto.getOrganisation());
        member.setWorkplace(dto.getWorkplace());
        member.setMemberType(dto.getMemberType());
        Training training = trainingDAO.findOne(dto.getTrainingId());
        member.setTraining(training);

        memberDAO.save(member);
        return member.getId().toString();
    }

    @Override
    public List<MemberDTO> findMembersByTrainingId(Integer trainingId) {
        return ConvertUtils.convertToMemberDTOs(memberDAO.findAllMembersByTrainingId(trainingId));
    }

    @Override
    public MemberDTO getSingleMember(Integer id) {
        return ConvertUtils.convertToMemberDTO(memberDAO.findOne(id));
    }

    @Override
    public String deleteMember(Integer id) {


        memberDAO.delete(id);

        return id.toString();
    }

    @Override
    public String deleteTraining(Integer trainingId) {
        trainingDAO.delete(trainingId);
        return trainingId.toString();
    }

    @Override
    public List<Training> getTrainingByFiscalYear(String fiscalYear) {
        return trainingDAO.findTrainingsByFiscalYear(fiscalYear);
    }

    @Override
    public int countNumberOfAttendeesInTraining(int id) {
        return memberDAO.countNumberOfTrainees(id);
    }

    @Override
    public int countNumberOfMale(int id) {
        return memberDAO.countNumberOfMaleMembers(id);
    }

    @Override
    public String countChildTrainingCenter(Integer id) {
        return trainingCenterDAO.countChildTrainingCenter(id).toString();
    }
}