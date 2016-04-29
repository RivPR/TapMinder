package data;

import entities.Neighborhood;
import entityData.State;

public class BreweryParameters {
	
	
	private String name;
	private String streetAddress;
	private String city;
	private State state;
	private Integer zipcode;
	private Neighborhood neighborhood;
	
	
	
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
	
	
	
	

}
