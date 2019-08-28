package ru.job4j.profession;

import java.util.Date;

public class Profession {

    private String name;
    private String surname;
    private String education;
    private Date birthday;

    public String getName() {

        return this.name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getSurname() {

        return this.surname;
    }

    public void setSurname(String surname) {

        this.surname = surname;
    }

    public String getEducation() {

        return this.education;
    }

    public void setEducation(String education) {

        this.education = education;
    }

    public Date getBirthday() {

        return this.birthday;
    }

    public void setBirthday(Date birthday) {

        this.birthday = birthday;
    }
}


