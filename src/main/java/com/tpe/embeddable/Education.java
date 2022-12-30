package com.tpe.embeddable;

import javax.persistence.Embeddable;

@Embeddable
public class Education {

    private String university;

    private String Department;

    public Education() {
    }

    public Education(String university, String department) {
        this.university = university;
        Department = department;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    @Override
    public String toString() {
        return "Education{" +
                "university='" + university + '\'' +
                ", Department='" + Department + '\'' +
                '}';
    }
}
