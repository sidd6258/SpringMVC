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
public class PhoneDaoImpl implements PhoneDao{

	//Session Factory object
	@Autowired
	private SessionFactory sessionFactory;
	
	//Implementation for profile creation
	public void createPhone(Phone phone) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try{
			session.saveOrUpdate(phone);
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
			throw e;
		}finally{
			session.close();
		}
	}

	//Implementation for profile retrieval
	public Phone getPhone(int phoneId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Phone phone = null;
		try{
			phone = (Phone) session.get(Phone.class, phoneId);
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
		}finally{
			session.close();
		}
		return phone;
	}

	//Implementation for profile deletion
	public void deletePhone(Phone phone) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try{
			session.delete(phone);
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
			throw e;
		}finally{
			session.close();
		}
	}
public int getMaxId() {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		int id=0;
		try{
			Query query = session.createQuery("SELECT max(id) FROM Phone phone");
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

public List<User> getUsers(int phId) {
	Session session = sessionFactory.openSession();
	Transaction tx = session.beginTransaction();
	List<User> users = new ArrayList<User>();
	Phone phone = null;
	try{
		phone = (Phone) session.get(Phone.class, phId);
		
		users.addAll(phone.getUsers());
		tx.commit();
	}catch(HibernateException e){
		tx.rollback();
		throw e;
	}finally{
		session.close();
	}
	return users;
}

}
