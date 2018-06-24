package com.bryan_alegria.androidexam.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class PersonData implements Serializable {
    private String fname;
    private String Lname;
    private String Bday;
    private String Email;
    private String Mobile;
    private String Address;
    private String contact_person;
    private String contact_person_phone_number;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getBday() {
        return Bday;
    }

    public void setBday(String bday) {
        Bday = bday;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getContact_person() {
        return contact_person;
    }

    public void setContact_person(String contact_person) {
        this.contact_person = contact_person;
    }

    public String getContact_person_phone_number() {
        return contact_person_phone_number;
    }

    public void setContact_person_phone_number(String contact_person_phone_number) {
        this.contact_person_phone_number = contact_person_phone_number;
    }
}
