package com.cms.dto;

import com.cms.model.Role;

import java.util.Set;

/**
 * Created by amit on 6/16/16.
 */

public class    UserDTO {

    private int id;

    private String username;
    private String password;
    private boolean enabled;
    private String firstName;

    private String middleName;

    private String lastName;

    private boolean isMale;

    private String dob;

    private String country;

    private String vdcOrMunicipality;
    private String streetAddress;

    private String district;

    private String zone;

    private long landlineNumber;

    private long mobileNumber;

    private String email;

    private Set<Role> roles;

    public String[] getRoless() {
        return roless;
    }

    public void setRoless(String[] roless) {
        this.roless = roless;
    }

    private String roless[];
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getVdcOrMunicipality() {
        return vdcOrMunicipality;
    }

    public void setVdcOrMunicipality(String vdcOrMunicipality) {
        this.vdcOrMunicipality = vdcOrMunicipality;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
