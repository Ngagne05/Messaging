package com.message.dao;


import com.message.dao.jpa.JpaMessageDao;
import com.message.dao.jpa.JpaUserDao;


public class DaoFactory {
	public DaoFactory() {
		
	}
	public static UserDao getUserDao() {
		return new JpaUserDao();		
	}
	public static messageDao getMessageDao() {
		return new JpaMessageDao();
	}
	
	
}
