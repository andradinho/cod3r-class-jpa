package test.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.basic.User;

public class NewUser {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		User newUser = new User("Arthur", "arthur@lanche.com");
		
		em.getTransaction().begin();
		em.persist(newUser);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
