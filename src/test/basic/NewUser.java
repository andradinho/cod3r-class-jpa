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
		
		User newUser = new User("Leo", "leoo@lanche.com");
		
		em.getTransaction().begin();
		em.persist(newUser);
		em.getTransaction().commit();
		
		System.out.println("O Id gerado foi: " + newUser.getId());
		
		em.close();
		emf.close();
	}
}
