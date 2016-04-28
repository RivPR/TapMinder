package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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

	private Brewery brewery;

}
