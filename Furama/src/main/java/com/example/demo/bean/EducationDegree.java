package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
public class EducationDegree {

    @Id
    private Integer educationDegreeId;
    private String educationDegreeName;

    @OneToMany(mappedBy = "educationDegree")
    @JsonManagedReference
    private Set<Employee> employees;

    public EducationDegree() {
    }

    public EducationDegree(Integer educationDegreeId, String educationDegreeName, Set<Employee> employees) {
        this.educationDegreeId = educationDegreeId;
        this.educationDegreeName = educationDegreeName;
        this.employees = employees;
    }
}
