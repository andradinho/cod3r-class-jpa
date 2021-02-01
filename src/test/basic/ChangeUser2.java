package test.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.basic.User;

public class ChangeUser2 {

public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		User user = em.find(User.class, 8L);
		user.setName("Donatello");
		user.setEmail("donatello@kawabanga.com");
		
		//em.merge(user); O JPA fará a mudança mesmo sem o merge.
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
