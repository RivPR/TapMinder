package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="beers")
public class Beer {

	@Id
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="abv")
	private Double hop_count;
	
	@Column(name="style")
	private String beerStyle;
	
	//TODO: 5k varchar
	@Column(name="description")
	private String description;
	
	@Column(name="image_link")
	private String imageLink;

	@OneToMany(mappedBy="beer")
	private List<BeerRating> ratings;
	
	@ManyToOne()
	@JoinColumn(name="breweries_id")
	private Brewery brewery;

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

	public Double getHop_count() {
		return hop_count;
	}

	public void setHop_count(Double hop_count) {
		this.hop_count = hop_count;
	}

	public String getBeerStyle() {
		return beerStyle;
	}

	public void setBeerStyle(String beerStyle) {
		this.beerStyle = beerStyle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public List<BeerRating> getRatings() {
		return ratings;
	}

	public void setRatings(List<BeerRating> ratings) {
		this.ratings = ratings;
	}

	public Brewery getBrewery() {
		return brewery;
	}

	public void setBrewery(Brewery brewery) {
		this.brewery = brewery;
	}
	

	
	
	
	
}
