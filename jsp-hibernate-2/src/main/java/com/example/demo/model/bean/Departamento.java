package com.example.demo.model.bean;

import javax.persistence.*;

@Entity
@Table(name = "departamento")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdeDep", nullable = false)
    private Integer id;

    @Column(name = "NomDep", length = 50)
    private String nomDep;

    @Column(name = "TelDep", length = 15)
    private String telDep;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomDep() {
        return nomDep;
    }

    public void setNomDep(String nomDep) {
        this.nomDep = nomDep;
    }

    public String getTelDep() {
        return telDep;
    }

    public void setTelDep(String telDep) {
        this.telDep = telDep;
    }

}