package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "position")
@Getter
@Setter
public class Position {
    @Id
    private Integer positionId;
    @Column(name = "position_name")
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
