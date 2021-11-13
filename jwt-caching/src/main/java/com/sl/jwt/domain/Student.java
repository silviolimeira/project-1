package com.sl.jwt.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String firstName;

    private String lastName;

    private String age;

    private Address address;

    private Major major;

}
