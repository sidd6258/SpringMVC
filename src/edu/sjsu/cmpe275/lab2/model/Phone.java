package edu.sjsu.cmpe275.lab2.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Phone")
public class Phone {
	    @Id
	    @Column(name="ID")
	    private int id;
	    @Column(name="NUMBER")
	    private String number;  // Note, phone numbers must be unique
	    @Column(name="DESCRIPTION")
	    private String description;
	    @Embedded
	    private Address address;
		@ManyToMany
		@JoinTable(
				name="USER_PHONE",
				joinColumns={@JoinColumn(name="PHONE_ID",referencedColumnName="ID")},
				inverseJoinColumns={@JoinColumn(name="USER_ID",referencedColumnName="ID")})	
	    private List<User> users;
		public List<User> getUsers() {
			return users;
		}
		public void setUsers(List<User> users) {
			this.users = users;
		}
		protected Phone() {
		}
		public Phone(int id, String number, String description, Address address) {
			super();
			this.id = id;
			this.number = number;
			this.description = description;
			this.address = address;
		}
		public Phone(int id, String number, String description, Address address,List<User> users) {
			super();
			this.id = id;
			this.number = number;
			this.description = description;
			this.address = address;
			this.users = users;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNumber() {
			return number;
		}
		public void setNumber(String number) {
			this.number = number;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}

}
