package com.message.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private long id;
	@Column(nullable=false,columnDefinition="VARCHAR(50) COLLATE latin1_general_cs")
	private String username;
	@Column(nullable=false,columnDefinition="VARCHAR(50) COLLATE latin1_general_cs")
	private String password;
	private String givenName;
	private String familyName;
	private String email;
	
	@ManyToMany
	@JoinTable(name="user_user")
	List<User> contacts;
	@OneToMany(mappedBy="sender")
	List<Message> sentMessages;
	@OneToMany(mappedBy="receiver")
	List<Message> receivedMessages;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<User> getContacts() {
		return contacts;
	}
	public void setContacts(List<User> contacts) {
		this.contacts = contacts;
	}
	public List<Message> getReceivedMessages() {
		return receivedMessages;
	}
	public void setReceivedMessages(List<Message> receivedMessages) {
		this.receivedMessages = receivedMessages;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Message> getSentMessages() {
		return sentMessages;
	}
	public void setSentMessages(List<Message> sentMessages) {
		this.sentMessages = sentMessages;
	}
		
}
