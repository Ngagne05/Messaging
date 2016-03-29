package com.message.dao.jpa;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.message.dao.UserDao;
import com.message.entity.User;
import com.message.util.PersistenceManager;

public class JpaUserDao implements UserDao{
	EntityManager em;
	public JpaUserDao() {
		
		em=PersistenceManager.getEntityManagerFactory().createEntityManager();
	}
	public void storeUser(User u) {
		EntityTransaction t=em.getTransaction();
		t.begin();
		em.persist(u);
		t.commit();
	}
	public User retrieveUser(String input) {	
		javax.persistence.Query q=em.createQuery("SELECT u FROM User as u where u.username='"+input+"'");	
		
		try {
			return  (User)q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		
	}
	public boolean isAuthenticated(String inputUsername, String inputPassword) {
		javax.persistence.Query q=em.createQuery("SELECT u FROM User as u where u.username='"+inputUsername+"' and u.password='"+inputPassword+"'");		
		
		return !q.getResultList().isEmpty();
	}
	public boolean existe(String inputUsername) {
		javax.persistence.Query q=em.createQuery("SELECT u FROM User as u where u.username='"+inputUsername+"'");		
		return !q.getResultList().isEmpty();
	}
	public void addContact(User u,User contact) {
		u.getContacts().add(contact);
		contact.getContacts().add(u);
		
		EntityTransaction t=em.getTransaction();
		t.begin();
		em.merge(u);
		em.merge(contact);
		t.commit();
		em.close();
	}
	public void updateUser(User u) {
		EntityTransaction t=em.getTransaction();
		t.begin();
		em.merge(u);		
		t.commit();
		em.close();
	}
	public int numberOfUser() {
		return  em.createNativeQuery("SELECT * FROM user ").getResultList().size();
	
	}
}
