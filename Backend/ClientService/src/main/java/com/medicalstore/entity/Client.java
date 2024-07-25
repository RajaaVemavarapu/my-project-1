package com.medicalstore.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="client")//Here is the Table name
public class Client {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	
	//validation for the client firstName
  //  @Pattern(regexp = "[a-zA-Z]{3,20}$" ,message = "First Name is Required")
    private String firstName;

   // @Pattern(regexp = "[a-zA-Z]{3,20}$" ,message = "Last Name is Required")
    private String lastName;

   // @NotBlank(message = "Contact number is required")
    //@Pattern(regexp = "\\d{10}", message = "Contact number must be 10 digits")
    private String contactNumber;

   // @NotBlank(message = "Address is required")
    private String address;

    //@Pattern(regexp = "^(.+)@(.+)$", message = "email in the format linke abc@gmail.com")
    private String email;
    
  //  @NotBlank(message = "Address is required")
    private String dateOfBirth;
    
  //  @Pattern(regexp = "[a-zA-Z]{3,20}$" ,message = "First Name is Required")
    private String username;

  //  @Pattern(regexp = "^[A-Z]+[a-zA-Z0-9@#$%^&*!]{6,20}$", message = "Password must be at least 6 characters & Atleast One Capital Letter and one Symbol")
    private String password;
  
    
	public Client() {
		super();
		
	}

	public Client(Long id, String firstName, String lastName, String contactNumber, String address, String email,
			String dateOfBirth, String username, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.address = address;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.username = username;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", contactNumber="
				+ contactNumber + ", address=" + address + ", email=" + email + ", dateOfBirth=" + dateOfBirth
				+ ", username=" + username + ", password=" + password + "]";
	}
	
}