package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="neighborhoods")
public class Neighborhood {

	@Id
	private int id;

	@Column(name="name")
	private String neighborhood;

	@OneToMany(mappedBy="neighborhood")
	private List<Brewery> breweries;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public List<Brewery> getBreweries() {
		return breweries;
	}

	public void setBreweries(List<Brewery> breweries) {
		this.breweries = breweries;
	}
	
	
	

	
	
	
	
	
}
