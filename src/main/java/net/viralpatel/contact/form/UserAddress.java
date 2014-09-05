package net.viralpatel.contact.form;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserAddress {

	
	private int id;
	@NotNull
	@Size(min=2,max=30)
	private String street1;
	@NotNull
	@Size(min=2,max=30)
	private String street2;
	@NotNull
	@Size(min=2,max=30)
	private String city;
	@NotNull
	@Size(min=2,max=30)
	private String state;
	@NotNull
	@Size(min=2,max=30)
	private String country;
	@NotNull
	@Size(min=2,max=30)
	private String name;
	@NotNull
	@Size(min=2,max=30)
	private String password;
	@NotNull
	@Size(min=2,max=30)
	private String confirm;
	@NotNull
	@Size(min=2,max=30)
	private String email;
	private List<Address> address;
	
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getStreet1() {
		return street1;
	}
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	public String getStreet2() {
		return street2;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	



}
