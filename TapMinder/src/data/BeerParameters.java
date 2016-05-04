package data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

public class BeerParameters {

	private Integer id;
	@Size(min=0, max=45, message="Please enter a valid name")
	private String name;
	@DecimalMin(value="0", message = "Enter a valid number between 1 and 100")
	@DecimalMax(value="100", message = "Enter a valid number between 1 and 100")
	private Double abvLow;
	@DecimalMin(value="0", message = "Enter a valid number between 1 and 100")
	@DecimalMax(value="100", message = "Enter a valid number between 1 and 100")
	private Double abvHigh;
	//TODO FIX
	@DecimalMin(value="0", message = "Enter a valid number")
	@DecimalMax(value="999999999", message = "Enter a valid number")
	private Double hopCountLow;
	@DecimalMin(value="0", message = "Enter a valid number")
	@DecimalMax(value="999999999", message = "Enter a valid number")
	private Double hopCountHigh;
	private String style;
	@DecimalMin(value="0", message = "Enter a valid number between 1 and 5")
	@DecimalMax(value="5", message = "Enter a valid number between 1 and 5")
	private Integer ratingLow;
	@DecimalMin(value="0", message = "Enter a valid number between 1 and 5")
	@DecimalMax(value="5", message = "Enter a valid number between 1 and 5")
	private Integer ratingHigh;
	
	
	
	
	
	
	public BeerParameters() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getAbvLow() {
		return abvLow;
	}
	public void setAbvLow(Double abvLow) {
		this.abvLow = abvLow;
	}
	public Double getAbvHigh() {
		return abvHigh;
	}
	public void setAbvHigh(Double abvHigh) {
		this.abvHigh = abvHigh;
	}

	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public Integer getRatingLow() {
		return ratingLow;
	}
	public void setRatingLow(Integer ratingLow) {
		this.ratingLow = ratingLow;
	}
	public Integer getRatingHigh() {
		return ratingHigh;
	}
	public void setRatingHigh(Integer ratingHigh) {
		this.ratingHigh = ratingHigh;
	}
	public Double getHopCountLow() {
		return hopCountLow;
	}
	public void setHopCountLow(Double hopCountLow) {
		this.hopCountLow = hopCountLow;
	}
	public Double getHopCountHigh() {
		return hopCountHigh;
	}
	public void setHopCountHigh(Double hopCountHigh) {
		this.hopCountHigh = hopCountHigh;
	}
	
	
	
}
