package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="beers")
public class Beer {
	//TODO attempting to add validation to this as a test
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="abv")	
	@DecimalMin(value="0")
	@DecimalMax(value="100")
	private Double abv;
	
	@Column(name="hop_count")
	@DecimalMin(value="0")
	@DecimalMax(value="20000000")
	private Double hopCount;
	
	@Column(name="style")
	private String beerStyle;
	
	//TODO: 5k varchar
	@Column(name="description")
	private String description;
	
	@Column(name="image_link")
	private String imageLink;

	@OneToMany(mappedBy="beer", fetch = FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private List<BeerRating> ratings;
	
	@ManyToOne()
	@JoinColumn(name="breweries_id")
	private Brewery brewery;
	

	private transient Double averageRating;
	

	
	
	



	public Double getAverageRating(){
		
		int count = 0;
		double total = 0;

		for (BeerRating beerRating : ratings) {
			count++;
			total += beerRating.getRating();	
			this.setAverageRating(total/count);
		}
		return (total/count);
	}
	
	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
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
