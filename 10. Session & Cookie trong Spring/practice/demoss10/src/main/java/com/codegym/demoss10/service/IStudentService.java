package com.codegym.demoss10.service;

import com.codegym.demoss10.model.Student;

import java.util.List;

public interface IStudentService {
List<Student> list();

    void save(Student student);
}
