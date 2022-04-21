package com.example.demo.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.example.demo.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class HibernateFiltro implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            request.setAttribute(HibernateUtil.HIBERNATE_SESSION, session);
            chain.doFilter(request, response);
            session = (Session) request.getAttribute(HibernateUtil.HIBERNATE_SESSION);
            session.flush();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }


    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
