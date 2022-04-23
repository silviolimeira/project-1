package com.example.demo.model.dao;

import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;

import java.util.List;

public class HibernateDAO<T> implements InterfaceDAO<T> {

    private Class<T> classe;
    private Session session;

    public HibernateDAO(Class<T> classe, Session session) {
        super();
        this.classe = classe;
        this.session = session;
    }

    @Override
    public void salvar(T bean) {
        session.save(bean);
    }

    @Override
    public void atualizar(T bean) {
        session.update(bean);
        session.flush();
        session.refresh(bean);
    }

    @Override
    public void excluir(T bean) {
        session.delete(bean);
    }

    @Override
    public T getBean(Integer id) {
        T bean = (T) session.get(classe, id);
        return bean;
    }

    @Override
    public List<T> getBeans() {
        List<T> beans = (List<T>) session.createCriteria(classe).list();
        session.getTransaction().commit();
        session.getTransaction().begin();
        return beans;
    }

    @Override
    public List<T> getBeansByExample(T bean) {
        Example example = Example.create(bean);
        example.enableLike(MatchMode.START);
        example.ignoreCase();
        return session.createCriteria(classe).add(example).list();
    }

}
