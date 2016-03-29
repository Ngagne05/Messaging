package com.message.dao;

import java.sql.Date;
import java.util.List;

import com.message.entity.Message;
import com.message.entity.User;

public interface messageDao {
	public void storeMessage(Message m);
	public List<Message> retrieveHistoryMessage(User user,User contact);
	public int numberOfMessage ();
	
}
