package com.application.dto;

import java.util.Set;

public class UniversityDTO {
    private int id;
    private String name;
    private String creationDate;
    private Set<StudentDTO> studentDTOSet;

    public Set<StudentDTO> getStudentDTOSet() {
        return studentDTOSet;
    }

    public void setStudentDTOSet(Set<StudentDTO> studentDTOSet) {
        this.studentDTOSet = studentDTOSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
}