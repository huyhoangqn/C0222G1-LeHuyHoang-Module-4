package com.codegym.music.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Music implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String singer;
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Music music = (Music) target;
        if (music.name.matches("^$")) {
            errors.rejectValue("name", "name.EmptyString");
        } else if (!music.name.matches("^[A-Z][a-z]*(\\\\ [A-Z][a-z]*)*$")) {
            errors.rejectValue("name", "name.invalidFormat");
        }

        if (music.singer.matches("^$")) {
            errors.rejectValue("singer", "singer.EmptyString");
        } else if (!music.singer.matches("^[A-Z][a-z]*(\\\\ [A-Z][a-z]*)*$")) {
            errors.rejectValue("singer", "singer.invalidFormat");
        }

        if (music.type.matches("^$")) {
            errors.rejectValue("type", "type.EmptyString");
        } else if (!music.type.matches("^[A-Z][a-z]*(\\\\ [A-Z][a-z]*)*$")) {
            errors.rejectValue("type", "type.invalidFormat");
        }
    }
}
