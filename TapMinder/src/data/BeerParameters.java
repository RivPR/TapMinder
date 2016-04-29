package data;

public class BeerParameters {

	private Integer id;
	private String name;
	private Double abvLow;
	private Double abvHigh;
	//TODO FIX
	private Double hopCountLow;
	private Double hopCountHigh;
	private String style;
	private Integer ratingLow;
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
