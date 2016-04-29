package testing;

import static org.junit.Assert.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.User;
import entityData.UserTypeName;

import static org.junit.Assert.*;

public class UserDataTest {

	
	EntityManagerFactory emf;
	EntityManager em;

	User user;
	
	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("tapminderdb");
		em = emf.createEntityManager();
		user = em.find(User.class, 8);
		
	}
	@Test
	public void userFirstname(){
		assertEquals("Geoffrey",user.getFirstname());
	}
	
	
	@Test
	public void userLastname(){
		assertEquals("Genes",user.getLastname());
	}
	
	
	@Test
	public void userEmail(){
		assertEquals("mrPoopyHead@fakemail.com",user.getEmail()); //case matters
	}
	
	
	@Test
	public void userPassword(){
		assertEquals("password",user.getPassword());
	}
	
	
	@Test
	public void userTypeID(){
		assertEquals(UserTypeName.Standard,user.getUsertype().getTypeName());
		
	}
	
	
	@Test
	public void userAccessLevel(){
		assertEquals(1,user.getUsertype().getAccessLevel());
	}
	
	
	@After
	public void tearDown() {
		em.close();
		emf.close();

	}

}
