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
@Table(name = "position")
@Getter
@Setter
public class Position {
    @Id
    private Integer positionId;

    private String name;

    @OneToMany(mappedBy = "position")
    @JsonManagedReference
    private Set<Employee> employees;

    public Position() {
    }

    public Position(Integer positionId, String name, Set<Employee> employees) {
        this.positionId = positionId;
        this.name = name;
        this.employees = employees;
    }

}
