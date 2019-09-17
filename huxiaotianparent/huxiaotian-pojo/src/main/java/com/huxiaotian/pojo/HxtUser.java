package com.huxiaotian.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class HxtUser implements Serializable {
    private String userId;

    private String name;

    private String gender;

    private String nationality;

    private BigDecimal deposit;

    private Date checkIn;

    private Date checkOut;

    private String idCardNo;

    private String userRoomId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality == null ? null : nationality.trim();
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo == null ? null : idCardNo.trim();
    }

    public String getUserRoomId() {
        return userRoomId;
    }

    public void setUserRoomId(String userRoomId) {
        this.userRoomId = userRoomId == null ? null : userRoomId.trim();
    }
}