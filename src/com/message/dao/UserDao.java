package com.message.dao;

import java.util.List;

import com.message.entity.User;

public interface UserDao {
	public void storeUser(User u);
	public boolean isAuthenticated(String name, String password);
	public boolean existe(String inputUsername);
	public User retrieveUser(String username);
	public void addContact(User u,User contact);
	public void updateUser(User u);
	public int numberOfUser();
}
