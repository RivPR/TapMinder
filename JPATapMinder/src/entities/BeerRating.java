package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="beer_ratings")
public class BeerRating {

	@Id
	private User user;
	@Id
	private Beer beer;
	




}
