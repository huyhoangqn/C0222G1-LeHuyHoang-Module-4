package com.codegym.furama.service;


import com.codegym.furama.entity.Gender;

public interface IGenderService {
    Iterable<Gender> findAll();
}
