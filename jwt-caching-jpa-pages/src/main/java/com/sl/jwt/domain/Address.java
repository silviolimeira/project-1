package com.sl.jwt.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    private String doorNo;

    private String street;

    private String city;

    private String state;

    private String zipCode;

}
