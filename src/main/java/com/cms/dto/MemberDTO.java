package com.cms.dto;

import com.cms.model.MemberType;

import java.util.Date;

/**
 * Created by amit on 7/22/16.
 */
public class    MemberDTO {
    private Integer memberId;

    private Integer trainingId;

    private MemberType memberType;

    private String firstName;

    private String middleName;

    private String lastName;

    private boolean isMale;

    private Date dob;

    private String country;

    private String streetAddress;

    private String vdcOrMunicipality;

    private String district;

    private String zone;

    private long landlineNumber;

    private long mobileNumber;

    private String email;

    private String organisation;

    private String workplace;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Integer trainingId) {
        this.trainingId = trainingId;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public long getLandlineNumber() {
        return landlineNumber;
    }

    public void setLandlineNumber(long landlineNumber) {
        this.landlineNumber = landlineNumber;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getVdcOrMunicipality() {
        return vdcOrMunicipality;
    }

    public void setVdcOrMunicipality(String vdcOrMunicipality) {
        this.vdcOrMunicipality = vdcOrMunicipality;
    }
}
