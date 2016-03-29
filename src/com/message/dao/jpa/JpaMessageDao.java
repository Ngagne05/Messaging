package com.message.dao.jpa;

import java.sql.Date;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.omg.CORBA.Object;

import com.message.dao.messageDao;
import com.message.entity.Message;
import com.message.entity.User;
import com.message.util.PersistenceManager;

public class JpaMessageDao implements messageDao {
	
	public void storeMessage(Message m) {
		EntityManager em=PersistenceManager.getEntityManagerFactory().createEntityManager();
		EntityTransaction t=em.getTransaction();
		t.begin();
		em.persist(m);
		t.commit();
		em.close();
		
	}
	public List<Message> retrieveHistoryMessage(User user,User contact) {
		EntityManager em=PersistenceManager.getEntityManagerFactory().createEntityManager();
		javax.persistence.Query q=em.createQuery("SELECT m FROM Message as m where (m.sender="+user.getId()+" and m.receiver="+contact.getId()+")or (m.sender="+contact.getId()+" and m.receiver="+user.getId()+") ORDER BY id");		
		
		return q.getResultList();
	}
	public int numberOfMessage () {
		EntityManager em=PersistenceManager.getEntityManagerFactory().createEntityManager();
		
		return em.createNativeQuery("SELECT * FROM message").getResultList().size();
	}
	
}
