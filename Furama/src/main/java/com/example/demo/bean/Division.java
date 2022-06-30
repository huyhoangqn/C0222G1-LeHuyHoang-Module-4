package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "division")
@Getter
@Setter
public class Division {
    @Id
    private Integer divisionId;

    private String divisionName;

    @OneToMany(mappedBy = "division")
    @JsonManagedReference
    private Set<Employee> employees;

    public Division() {
    }

    public Division(Integer divisionId, String divisionName, Set<Employee> employees) {
        this.divisionId = divisionId;
        this.divisionName = divisionName;
        this.employees = employees;
    }
}
