package com.codegym.register_form.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class User implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    @NotNull(message = "Khong duoc de trong")
    @Min(value = 0, message = "Tuổi không được nhỏ hơn 0")
    @Max(value = 130, message = "Tuổi không được lớn hơn 130")
    private Integer age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (user.firstName.matches("^$")) {
            errors.rejectValue("firstName", "firstName.EmptyString");
        } else if (!user.firstName.matches("^[A-Z a-z]{2,10}$")) {
            errors.rejectValue("firstName", "firstName.invalidFormat");
        }

        if (user.lastName.matches("^$")) {
            errors.rejectValue("lastName", "lastName.EmptyString");
        } else if (!user.lastName.matches("^[A-Z a-z]{2,10}$")) {
            errors.rejectValue("lastName", "lastName.invalidFormat");
        }

        if (user.phone.matches("^$")) {
            errors.rejectValue("phone", "phone.EmptyString");
        } else if (!user.phone.matches("^(84|0[3|5|7|8|9])+([0-9]{8})$")) {
            errors.rejectValue("phone", "phone.invalidFormat");
        }

        if (user.email.matches("^$")) {
            errors.rejectValue("email", "email.EmptyString");
        } else if (!user.email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            errors.rejectValue("email", "email.invalidFormat");
        }
    }
}
