package com.example.employeeportal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
@Document(collection = "employees")
public class Employee {
    @Id
    private String id;
    private String empCode;
    private String empName;
    private String fatherName;
    private Double mobileNo;
    private LocalDate dateOfJoining;
    private LocalDate dateOfBirth;
    private String panNo;
    private String aadharNo;
    private String address;
    private String officialMail;
    private String personalMail;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Double getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Double mobileNo) {
        this.mobileNo = mobileNo;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public String getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(String aadharNo) {
        this.aadharNo = aadharNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOfficialMail() {
        return officialMail;
    }

    public void setOfficialMail(String officialMail) {
        this.officialMail = officialMail;
    }

    public String getPersonalMail() {
        return personalMail;
    }

    public void setPersonalMail(String personalMail) {
        this.personalMail = personalMail;
    }
}
