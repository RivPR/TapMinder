package data;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import entities.Beer;

public class GETBEERBYNAMETEST {
	static TapMinderDBDAO dao;
	
	public static void main(String[] args) {
//		ClassPathXmlApplicationContext context = 
//	             new ClassPathXmlApplicationContext("tapminder-servlet.xml");
//		dao = context.getBean(TapMinderDBDAO.class,"dao");
//		
//		BeerParameters bp = new BeerParameters();
//		bp.setName("Vanilla porter");
//		List<Beer> beerList = dao.getBeers(bp);
//	
//		
		
		
		int ratingLow = 2;
		int ratingHigh = 3;
		
		List<Beer> beerList = em.createQuery("SELECT b FROM Beer b WHERE (b.rating =< :high ) AND ( b.rating >= :low)",Beer.class).setParameter("high", ratingHigh).setParameter("low", ratingLow).getResultList();
		
		
		
		
	}
	
}
