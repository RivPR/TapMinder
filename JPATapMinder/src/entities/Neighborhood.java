package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="neighborhood")
public class Neighborhood {

	@Id
	private int id;

	@Column(name="name")
	private String neighborhood;

	@OneToMany(mappedBy="neighborhood_id")
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

	
	
	
	
}
