package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import entityData.State;

@Entity
@Table(name="breweries")
public class Brewery {
	
	@Id
	private int id;
	
	@Column(name="name")
	@Size(min=1, max=45, message = "Name length is invalid")
	private String name;
	
	@Column(name="street_address")
	@Size(max=45, message = "Address is too long")
	private String streetAddress;
	
	@Column(name="city")
	@Size(max=45,message = "City is too long")
	private String city;
	
	
	@Column(name="state")
//	@Size(max=2, message = "Please enter an abbreviation (ex. CO")
	@Enumerated(EnumType.STRING)
	private State state;
	
	@Column(name="zip")
	@DecimalMin(value="0",message = "Enter a valid 5 Digit Zip")
	@DecimalMax(value="99999", message = "Zip is too long")
	private Integer zip;
	
	@Column(name="image_link")
	@Size(max=200,message = "Link is too long")
	private String imageLink;
	
	@Column(name="brewery_link")
	@Size(max=200,message = "Link is too long")
	private String breweryLink;
	
	@ManyToOne()
	@JoinColumn(name = "neighborhood_id")
	private Neighborhood neighborhood;

	@OneToMany(mappedBy="brewery", cascade={CascadeType.PERSIST, CascadeType.REMOVE},  fetch = FetchType.EAGER)
	List<Beer> beerList;

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

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String street_address) {
		this.streetAddress = street_address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public String getBreweryLink() {
		return breweryLink;
	}

	public void setBreweryLink(String breweryLink) {
		this.breweryLink = breweryLink;
	}

	public Neighborhood getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(Neighborhood neighborhood) {
		this.neighborhood = neighborhood;
	}

	public List<Beer> getBeerList() {
		return beerList;
	}

	public void setBeerList(List<Beer> beerList) {
		this.beerList = beerList;
	}

	@Override
	public String toString() {
		return "Brewery [id=" + id + ", name=" + name + ", streetAddress=" + streetAddress + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", imageLink=" + imageLink + ", breweryLink=" + breweryLink
				+ ", neighborhood=" + neighborhood +  "]";
	}
	
	
	
	
	

}

