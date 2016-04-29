package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import entityData.State;

@Entity
@Table(name="breweries")
public class Brewery {
	
	@Id
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="street_address")
	private String streetAddress;
	
	@Column(name="city")
	private String city;
	
	
	@Column(name="state")
	@Enumerated(EnumType.STRING)
	private State state;
	
	@Column(name="zip")
	private int zip;
	
	@Column(name="image_link")
	private String imageLink;
	
	@Column(name="brewery_link")
	private String breweryLink;
	
	@ManyToOne()
	@JoinColumn(name = "neighborhood_id")
	private Neighborhood neighborhood;

	@OneToMany(mappedBy="brewery")
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
	
	
	
	
	

}

