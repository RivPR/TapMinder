package testing;

	


	import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.User;

	public class PickUsersTest {

	public static void main(String[] args) {
		
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("tapminderdb");
			EntityManager em = emf.createEntityManager();

			List<User> users = em.createQuery("SELECT u FROM User u WHERE u.firstname LIKE '%%' and u.lastname LIKE '%%' AND u.email LIKE '%%'",User.class).getResultList();
			
			for (User user : users) {
				System.out.println(user.getFirstname());
			}
			
			em.close();
			emf.close();
		}
		
		
	}


