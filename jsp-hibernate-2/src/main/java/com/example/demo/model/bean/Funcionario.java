package com.example.demo.model.bean;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "funcionario")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdeFun", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IdeDep", nullable = false)
    private Departamento ideDep;

    @Column(name = "NomFun", length = 50)
    private String nomFun;

    @Column(name = "TelFun", length = 15)
    private String telFun;

    @Column(name = "CarFun", length = 30)
    private String carFun;

    @Column(name = "SalFun", precision = 15, scale = 2)
    private BigDecimal salFun;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Departamento getIdeDep() {
        return ideDep;
    }

    public void setIdeDep(Departamento ideDep) {
        this.ideDep = ideDep;
    }

    public String getNomFun() {
        return nomFun;
    }

    public void setNomFun(String nomFun) {
        this.nomFun = nomFun;
    }

    public String getTelFun() {
        return telFun;
    }

    public void setTelFun(String telFun) {
        this.telFun = telFun;
    }

    public String getCarFun() {
        return carFun;
    }

    public void setCarFun(String carFun) {
        this.carFun = carFun;
    }

    public BigDecimal getSalFun() {
        return salFun;
    }

    public void setSalFun(BigDecimal salFun) {
        this.salFun = salFun;
    }

}