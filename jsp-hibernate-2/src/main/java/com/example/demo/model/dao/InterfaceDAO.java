package com.example.demo.model.dao;

import java.util.List;

public interface InterfaceDAO<T> {

    void salvar(T bean);
    void atualizar(T bean);
    void excluir(T bean);
    T getBean(Integer id);
    List<T> getBeans();
    List<T> getBeansByExample(T bean);

}
