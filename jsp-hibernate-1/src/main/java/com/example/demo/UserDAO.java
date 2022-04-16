package com.example.demo;

import com.example.demo.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;


public class UserDAO {
	SessionFactory factory = null;
	Session session = null;
	public UserDAO() {
	}

	public boolean insertUser(User user) {
		boolean flag = false;
		try {
			factory = SessionFactoryUtil.getSessionFactory();
			session= factory.openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			factory.close();
			flag = true;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	public boolean deleteUser(int id) {
		boolean flag = false;
		try {
			factory = SessionFactoryUtil.getSessionFactory();
			session= factory.openSession();
			session.beginTransaction();
			User emp = session.get(User.class, id);
			if(emp != null) session.delete(emp);
			session.getTransaction().commit();
			factory.close();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public User selectUser(int id) {
		User employee = null;
		try {
			factory = SessionFactoryUtil.getSessionFactory();
			session= factory.openSession();
			employee = session.get(User.class, id);
			factory.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return employee;
	}

	public List<User> selectAllUsers() {
		List<User> empList = null;
		try {
			factory = SessionFactoryUtil.getSessionFactory();
			session= factory.openSession();
			empList = session.createQuery("from User", User.class).getResultList();
			factory.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return empList;
	}

	public boolean updateUser(User user)  {
		boolean flag = false;
		try {
			factory = SessionFactoryUtil.getSessionFactory();
			session= factory.openSession();
			session.beginTransaction();
			session.update(user);
			session.getTransaction().commit();
			factory.close();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}