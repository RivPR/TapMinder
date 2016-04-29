package data;

import java.util.List;

import entities.Beer;

public class GETBEERBYNAMETEST {
	static TapMinderDBDAO dao = new TapMinderDBDAO();
	
	public static void main(String[] args) {
		BeerParameters bp = new BeerParameters();
		bp.setName("Vanilla porter");
		List<Beer> beerList = dao.getBeers(bp);
		
		
	}
	
}
