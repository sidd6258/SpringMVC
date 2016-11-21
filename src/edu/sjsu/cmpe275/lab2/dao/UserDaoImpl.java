package edu.sjsu.cmpe275.lab2.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.sjsu.cmpe275.lab2.model.Phone;
import edu.sjsu.cmpe275.lab2.model.User;

/**
 * 
 Profile Dao Implementation
 *
 */
@Repository
public class UserDaoImpl implements UserDao{

	//Session Factory object
	@Autowired
	private SessionFactory sessionFactory;
	
	//Implementation for profile creation
	public void createUser(User user) {
		
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			
			session.saveOrUpdate(user);
			System.out.println("Before committing save transaction");
			tx.commit();
			System.out.println("After committing save transaction");
			System.out.println("*****");	
		}catch(HibernateException e){
			tx.rollback();
			throw e;
		}finally{
			session.close();
		}
	}

	//Implementation for profile retrieval
	public User getUser(int userId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		User user = null;
		try{
			user = (User) session.get(User.class, userId);
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
		}finally{
			session.close();
		}
		return user;
	}

	//Implementation for profile deletion
	public void deleteUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try{
			session.delete(user);
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
			throw e;
		}finally{
			session.close();
		}
	}
	public List<Phone> getPhones(int userId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Phone> phones = new ArrayList<Phone>();
		User user = null;
		try{
			user = (User) session.get(User.class, userId);
			
			phones.addAll(user.getPhones());
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
			throw e;
		}finally{
			session.close();
		}
		return phones;
	}
public int getMaxId() {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		int id=0;
		try{
			Query query = session.createQuery("SELECT max(id) FROM User user");
			if((Integer)query.iterate().next()!=null){
			id=(Integer)query.iterate().next();}
			System.out.println("Max phoneId: "+id);
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
			throw e;
		}finally{
			session.close();
		}
		return id;
	}

}
