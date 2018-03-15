package com.example.felig.criminalintent;

import java.util.List;
import java.util.UUID;
import java.util.Date;

/**
 * Created by felig on 2/5/2018.
 */

public class Friend extends Object {
    private UUID mId;
    private String mName;
    private String mLastName;
    private String nickName;
    private Date mBirthday;
    private List<String> interests;
    private String mPhone;

    public Friend(String inputName, String inputLastName) {
        mId = UUID.randomUUID();
        mName = inputName;
        mLastName = inputLastName;
    }
    public UUID getId() {
        return mId;
    }
    public Date getBirthday() {
        return mBirthday;
    }
    public void setBirthday(Date date) {
        mBirthday = date;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }
}
