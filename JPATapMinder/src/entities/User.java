package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {

	@Id
	private int id;
	
	@Column(name="firstname")
	@Size(min=1, max=45, message="Please enter a valid first name")
	private String firstname;
	@Column(name="lastname")
	@Size(min=1, max=45, message="Please enter a valid last name")
	private String lastname;
	@Column(name="email")
	@Size(min=1, max=45, message="Please enter a valid email")
	private String email;
	@Column(name="password")
	@Size(min=1, max=45, message="Please enter password between 1 and 45")
	private String password;	
	@ManyToOne()
	@JoinColumn(name="usertype_id")
	private UserType usertype;
	
	@Column
	@Size(min=1, max=2500, message="Please use a shorter URL")
	private String picture;
	@Column
	@Size(min=1, max=160, message="Status message has a max of 160 characters")
	private String status;
	
	@OneToMany(mappedBy="user", fetch = FetchType.EAGER, cascade= CascadeType.REMOVE)//added type all for list updating// , cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	List<BeerRating> ratings;
	
	public User(){
		
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

	public UserType getUsertype() {
		return usertype;
	}

	public void setUsertype(UserType usertype) {
		this.usertype = usertype;
	}

	public List<BeerRating> getRatings() {
		return ratings;
	}

	public void setRatings(List<BeerRating> ratings) {
		this.ratings = ratings;
	}
	
	

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + ", usertype=" + usertype + "]";
	}


	
	
	
}
