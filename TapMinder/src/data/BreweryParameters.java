package data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import entities.Brewery;
import entities.Neighborhood;
import entityData.State;

public class BreweryParameters {
	
	@Size(min=0, max=45, message="Please enter a vlid name")
	private String name;
	@Size(min=0, max=45, message="Please enter a vlid name")
	private String streetAddress;
	@Size(min=0, max=45, message="Please enter a vlid name")
	private String city;
	private State state;
	@DecimalMin(value="0", message = "Enter a valid five digit zip code")
	@DecimalMax(value="99999", message = "Enter a valid five digit zip code")
	private Integer zipcode;
	private Neighborhood neighborhood;
	private Brewery brewery;
	
	
	public BreweryParameters() {
		super();
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



	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
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



	public Integer getZipcode() {
		return zipcode;
	}



	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}



	public Neighborhood getNeighborhood() {
		return neighborhood;
	}



	public void setNeighborhood(Neighborhood neighborhood) {
		this.neighborhood = neighborhood;
	}



	public Brewery getBrewery() {
		return brewery;
	}



	public void setBrewery(Brewery brewery) {
		this.brewery = brewery;
	}
	
	
	
	

}
