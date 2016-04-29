package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="beers")
public class Beer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="abv")
	private Double abv;
	
	@Column(name="hop_count")
	private Double hopCount;
	
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

	public double getAverageRating(){
		int count = 0;
		double rating = 0;
		
		for (BeerRating beerRating : ratings) {
			rating += beerRating.getRating();
			count++;
		}
		
		if(count != 0){
			return (rating/count);
		}
		
		return 0;
	}
	
	
	public int getId() {
		return id;
	}

	public Double getAbv() {
		return abv;
	}

	public void setAbv(Double abv) {
		this.abv = abv;
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

	public Double getHopCount() {
		return hopCount;
	}

	public void setHopCount(Double hopCount) {
		this.hopCount = hopCount;
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
