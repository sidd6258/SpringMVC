package edu.sjsu.cmpe275.lab2.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="User")
public class User {
	@Id
	@Column
    private int id;
	@Column(name="FIRST_NAME")
    private String firstname;
	@Column(name="LAST_NAME")
    private String lastname;
	@Column(name="TITLE")
    private String title;
	@Embedded
    private Address address;
	@ManyToMany
	@JoinTable(
			name="USER_PHONE",
			joinColumns={@JoinColumn(name="USER_ID",referencedColumnName="ID")},
			inverseJoinColumns={@JoinColumn(name="PHONE_ID",referencedColumnName="ID")})	
    private List<Phone> phones;
	protected User() {
	}
	public User(int id, String firstname, String lastname, String title, Address address, List<Phone> phones) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.title = title;
		this.address = address;
		this.phones = phones;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Phone> getPhones() {
		return phones;
	}
	
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
    
 }

