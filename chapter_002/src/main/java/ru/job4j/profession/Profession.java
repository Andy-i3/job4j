package ru.job4j.profession;

import java.util.Date;

public class Profession {

    private String name;
    private String surname;
    private String education;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setName(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getEducation() {
        return this.education;
    }

    public Date getBirthday() {
        return this.birthday;
    }


}


